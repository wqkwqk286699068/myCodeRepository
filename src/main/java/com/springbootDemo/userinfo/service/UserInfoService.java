package com.springbootDemo.userinfo.service;

import java.util.ArrayList;

import com.springbootDemo.userinfo.entity.UserInfoDO;

public interface UserInfoService {
	
	public ArrayList<UserInfoDO> getUserListAll();
	
	public ArrayList<UserInfoDO> getUserList();

}
