package com.springbootDemo.common.suanfa;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 12, 4, 2, 5, 79, 6, 6, 6 };

		long start = System.nanoTime();
		sort(arr, 0, arr.length - 1);
		System.out.println("排序结果 :" + Arrays.toString(arr));
		long end = System.nanoTime();

		System.out.println("运行时间:" + (end - start) / 100000 + " ms");
	}

	/**
	 * 对arr[first] - arr[last] 进行排序
	 *
	 * @param arr   需要排序的数组
	 * @param first 数组中的起始值
	 * @param last  数组中的最后
	 */
	private static void sort(int[] arr, int first, int last) {
		// 判断下标是否存在有问题
		if (first >= last) {
			return;
		}
		// 赋予变量, 接收,便于更改
		int i = first;
		int j = last;
		while (i < j) {
			// 取出第一个元素作为基准值
			int one = arr[i];
			/*-----------右侧的轮询------------*/
			// 如果 最后一个值大于等于基准值 并且 i坐标 小于 j坐标 (防止坐标冲突)
			while (arr[j] >= one && i < j) {
				// 如果满足条件的话, 需要将指针,向左移动
				j--;
			}
			// 进行交换
			swap(arr, i, j);
			/*-----------左侧的轮询------------*/
			// 如果 第一个值 小于等于基准值并且 i坐标 小于 j坐标 (防止坐标冲突)
			while (arr[i] <= one && i < j) {
				// 如果满足条件的话, 需要将指针,向右移动
				i++;
			}
			// 进行交换
			swap(arr, i, j);
		}

		/*-----------进行递归操作------------*/
		// 对于基准左侧的集合 重复操作
		sort(arr, first, i - 1);
		// 对于基准右侧的集合 重复操作
		sort(arr, i + 1, last);
	}

	/**
	 * 单独提出一个方法用来进行数值的交换 这个方式会使运行速度降低
	 *
	 * @param arr 调用方法时需要进行交换的数组
	 * @param i   坐标
	 * @param j   坐标
	 */
	static void swap(int[] arr, int i, int j) {
		if (i < j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}

}
