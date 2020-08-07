package com.springbootDemo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springbootDemo.common.Returns;
import com.springbootDemo.login.entity.WqkUserLoginDO;
import com.springbootDemo.login.service.WqkUserLoginService;

/**
 * 用户登录
 * 
 * @author msi
 * @version 1.0
 */
@Controller
@RequestMapping("userLogin")
public class WqkUserLoginController {

	@Autowired
	WqkUserLoginService wqkUserLoginService;

	/**
	 * 用户登录
	 * 
	 * @param wqkUserLoginDO
	 * @return
	 */
	@RequestMapping("/isLogin")
	@ResponseBody
	public ModelAndView isLogin(WqkUserLoginDO wqkUserLoginDO) {
		Returns r = wqkUserLoginService.searchUserInfo(wqkUserLoginDO);
		if(r.get("code").equals(0)){
			return new ModelAndView("user");
		}
		
		return new ModelAndView("login", Returns.error());
	}

	@RequestMapping("/returnHtml")
	public ModelAndView returnHtml(){
		ModelAndView mv =  new ModelAndView("user");
		return mv;
	}
	
}
