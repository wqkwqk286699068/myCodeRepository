package com.springbootDemo.reflex;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbootDemo.AppTest;
import com.springbootDemo.config.ApplicationContextConfig;
import com.springbootDemo.userinfo.entity.UserInfoDO;
import com.springbootDemo.userinfo.service.Impl.UserInfoImpl;

/**
 * 反射测试
 * 
 * @author msi
 * 
 */
public class ReflexTest extends AppTest{

	@Autowired
	UserInfoImpl userInfoImpl;

	@Test
	public void test() {
		UserInfoImpl userInfo = new UserInfoImpl();
		System.out.println(userInfo.getClass());
		System.out.println(userInfoImpl.getClass());
		System.out.println(UserInfoImpl.class);
		Object obj = ApplicationContextConfig.getBean(UserInfoImpl.class);
		System.out.println(obj.getClass());
		Class cla = obj.getClass();
		try {
			Method mt = cla.getMethod("getUserListAll");
			ArrayList<UserInfoDO> list = (ArrayList<UserInfoDO>) mt
					.invoke(userInfo);
			for (UserInfoDO userInfoDO : list) {
				System.out.println(userInfoDO.getChineseName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
