package com.springbootDemo.userinfo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootDemo.userinfo.entity.UserInfoDO;
import com.springbootDemo.userinfo.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;

	@RequestMapping("/getuserlist")
	@ResponseBody
	public ArrayList<UserInfoDO> getUserList() {
		return userInfoService.getUserList();
	}

}
