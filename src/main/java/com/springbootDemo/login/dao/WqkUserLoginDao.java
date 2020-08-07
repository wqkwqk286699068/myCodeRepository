package com.springbootDemo.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springbootDemo.login.entity.WqkUserLoginDO;
import com.springbootDemo.userinfo.entity.UserInfoDO;

/**
 * 用户登录dao
 * 
 * @author 王钦凯
 * @version 1.0
 * 
 */
@Mapper
public interface WqkUserLoginDao {

	/**
	 * 用户登录查询用户信息
	 * 
	 * @param wqkUserLoginDO
	 * @return
	 */
	public UserInfoDO searchUserInfo(WqkUserLoginDO wqkUserLoginDO);

}
