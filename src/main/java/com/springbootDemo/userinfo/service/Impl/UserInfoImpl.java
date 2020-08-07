package com.springbootDemo.userinfo.service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootDemo.config.ApplicationContextConfig;
import com.springbootDemo.userinfo.dao.UserInfoDao;
import com.springbootDemo.userinfo.entity.UserInfoDO;
import com.springbootDemo.userinfo.service.UserInfoService;

@Service
public class UserInfoImpl implements UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;

	@Override
	public ArrayList<UserInfoDO> getUserList() {
		if(userInfoDao == null){
			userInfoDao = ApplicationContextConfig.getBean(UserInfoDao.class);
		}
		return userInfoDao.getUserList();
	}

	@Override
	public ArrayList<UserInfoDO> getUserListAll() {
		if(userInfoDao == null){
			userInfoDao = ApplicationContextConfig.getBean(UserInfoDao.class);
		}
		return userInfoDao.getUserListAll();
	}
}
