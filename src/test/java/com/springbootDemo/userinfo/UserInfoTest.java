package com.springbootDemo.userinfo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbootDemo.AppTest;
import com.springbootDemo.userinfo.dao.UserInfoDao;
import com.springbootDemo.userinfo.entity.UserInfoDO;
import com.springbootDemo.userinfo.service.UserInfoService;

public class UserInfoTest extends AppTest {

	@Autowired
	UserInfoDao userInfoDao;

	@Autowired
	UserInfoService userInfoService;

	@Resource
	private SqlSessionFactory sqlSessionFactory;

	// @Test
	public void test() {

		ArrayList<UserInfoDO> list = userInfoService.getUserList();
		for (UserInfoDO userInfoDO : list) {
			System.out.println(userInfoDO);
		}

	}

	@Test
	public void oneSqlSession() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();

			UserInfoDao userInfo = sqlSession.getMapper(UserInfoDao.class);
			// 执行第一次查询
			List<UserInfoDO> students = userInfo.getUserList();
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			}
			System.out.println("=============开始同一个 Sqlsession 的第二次查询============");
			// 同一个 sqlSession 进行第二次查询
			List<UserInfoDO> stus = userInfo.getUserList();
			Assert.assertEquals(students, stus);
//			System.out.println(students.get(0) == stus.get(0));
//			students.get(0).setChineseName("呵呵");
//			System.out.println(students.get(0).getChineseName());
//			System.out.println(stus.get(0).getChineseName());
			for (int i = 0; i < stus.size(); i++) {
				System.out.println("stus:" + stus.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
