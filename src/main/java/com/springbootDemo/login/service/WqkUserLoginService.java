package com.springbootDemo.login.service;

import com.springbootDemo.common.Returns;
import com.springbootDemo.login.entity.WqkUserLoginDO;

/**
 * 用户登录服务类
 * 
 * @author 王钦凯
 * @version 1.0
 * 
 */
public interface WqkUserLoginService {

	/**
	 * 用户登录查询用户信息
	 * 
	 * @param wqkUserLoginDO
	 * @return
	 */
	public Returns searchUserInfo(WqkUserLoginDO wqkUserLoginDO);
}
