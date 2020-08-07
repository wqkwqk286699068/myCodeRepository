package com.springbootDemo.common.suanfa;

public class SearchErFen {

	//
	// public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	// int length1 = nums1.length, length2 = nums2.length;
	// int totalLength = length1 + length2;
	// if (totalLength % 2 == 1) {
	// int midIndex = totalLength / 2;
	// double median = getKthElement(nums1, nums2, midIndex + 1);
	// return median;
	// } else {
	// int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
	// double median = (getKthElement(nums1, nums2, midIndex1 + 1) +
	// getKthElement(
	// nums1, nums2, midIndex2 + 1)) / 2.0;
	// return median;
	// }
	// }

	public int getKthElement(int[] nums1, int[] nums2, int k) {
		/*
		 * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1]
		 * 进行比较 这里的 "/" 表示整除 nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个 nums2
		 * 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个 取 pivot = min(pivot1,
		 * pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个 这样 pivot
		 * 本身最大也只能是第 k-1 小的元素 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k
		 * 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组 如果 pivot = pivot2，那么 nums2[0 .. k/2-1]
		 * 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组 由于我们 "删除" 了一些元素（这些元素都比第 k
		 * 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
		 */

		int length1 = nums1.length, length2 = nums2.length;
		int index1 = 0, index2 = 0;
		int kthElement = 0;

		while (true) {
			// 边界情况
			if (index1 == length1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == length2) {
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			// 正常情况
			int half = k / 2;
			int newIndex1 = Math.min(index1 + half, length1) - 1;
			int newIndex2 = Math.min(index2 + half, length2) - 1;
			int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
			if (pivot1 <= pivot2) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 6, 8 };
		int[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SearchErFen se = new SearchErFen();
		System.out.println(se.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 如果第一个数组长度大于第二个数组，则将两个数组换位，保证第一个数组长度小于第二个数组
		if (nums1.length > nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		// 第一个数组边界
		int m = nums1.length;
		// 第二个数组边界
		int n = nums2.length;

		// 分割线左边的所有元素需要满足的个数 m + (n - m + 1) /
		// 2，这种写法的目的是不论两数组的和是否是奇偶数都可以正确计算分割线的位置
		int totalLeft = (m + n + 1) / 2;

		// 在 nums1 的区间 [0, m] 里查找恰当的分割线，
		// 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
		int left = 0;
		int right = m;

		while (left < right) {
			// 获取第一个数组分隔线右边第一个数的位置
			int i = left + (right - left + 1) / 2;
			// 获取第二个数组分隔线右边第一个数的位置
			int j = totalLeft - i;
			// i-1是数组1分割线左边最后一个数的坐标，这里判断如果数组1分割线左边最大的数大于数组二分割线右边最小的数，则当前数组1的分割线位置不合适
			if (nums1[i - 1] > nums2[j]) {
				// 下一轮搜索的区间 [left, i - 1]
				right = i - 1;
			} else {
				// 下一轮搜索的区间 [i, right]
				left = i;
			}
		}

		// 数组1分割线位置
		int i = left;
		// 计算数组2分割线位置
		int j = totalLeft - i;
		int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
		int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
		int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
		int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

		if (((m + n) % 2) == 1) {
			return Math.max(nums1LeftMax, nums2LeftMax);
		} else {
			return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
		}
	}

}
