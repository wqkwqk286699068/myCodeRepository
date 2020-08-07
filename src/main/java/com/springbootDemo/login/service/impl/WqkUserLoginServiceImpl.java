package com.springbootDemo.login.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootDemo.common.Returns;
import com.springbootDemo.login.dao.WqkUserLoginDao;
import com.springbootDemo.login.entity.WqkUserLoginDO;
import com.springbootDemo.login.service.WqkUserLoginService;
import com.springbootDemo.login.tool.LoginTool;
import com.springbootDemo.userinfo.entity.UserInfoDO;

/**
 * 用户登录实现类
 * 
 * @author 王钦凯
 * @version 1.0
 * 
 */
@Service
public class WqkUserLoginServiceImpl implements WqkUserLoginService {

	@Autowired
	WqkUserLoginDao wqkUserLoginDao;

	@Override
	public Returns searchUserInfo(WqkUserLoginDO wqkUserLoginDO) {
		UserInfoDO userDo = wqkUserLoginDao.searchUserInfo(wqkUserLoginDO);
		
		if(userDo == null){
			return Returns.error(LoginTool.ERRCODE, true, LoginTool.ERR_USER_MSG);
		}
		if (wqkUserLoginDO.getPassword() == null || !wqkUserLoginDO.getPassword().equals(userDo.getPassword())) {
			return Returns.error(LoginTool.ERRCODE, true, LoginTool.ERR_PASS_MSG);
		}
		return Returns.ok(LoginTool.CODE, true, LoginTool.SUCCESS_LOGIN_MSG);
	}

}
