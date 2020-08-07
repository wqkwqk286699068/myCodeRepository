package com.springbootDemo.login;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbootDemo.AppTest;
import com.springbootDemo.common.Returns;
import com.springbootDemo.login.entity.WqkUserLoginDO;
import com.springbootDemo.login.service.WqkUserLoginService;

/**
 * 登录单元测试
 * 
 * @author msi
 * 
 */
public class WqkUserLoginTest extends AppTest{

	@Autowired
	WqkUserLoginService wqkUserLoginService;

	@Test
	public void Test() {
		WqkUserLoginDO wqkUserLoginDO = new WqkUserLoginDO();
		wqkUserLoginDO.setUserAccountCode("guanyu12@aliyun.com");
		wqkUserLoginDO.setPassword("1234567");
		Returns r = wqkUserLoginService.searchUserInfo(wqkUserLoginDO);
		System.out.println(r.isSuccess());
		System.out.println(r);
	}

}
