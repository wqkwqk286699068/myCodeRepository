package com.springbootDemo.userinfo.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.springbootDemo.userinfo.entity.UserInfoDO;

@Mapper
public interface UserInfoDao {

	public ArrayList<UserInfoDO> getUserListAll();
	
	public ArrayList<UserInfoDO> getUserList();
}