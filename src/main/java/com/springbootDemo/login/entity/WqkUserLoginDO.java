package com.springbootDemo.login.entity;

import java.io.Serializable;

/**
 * 用户登录实体
 * 
 * @author 王钦凯
 * @version 1.0
 * 
 */
public class WqkUserLoginDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3274914740740628573L;

	/**
	 * 用户账号
	 */
	private String userAccountCode;

	/**
	 * 密码
	 */
	private String password;

	public String getUserAccountCode() {
		return userAccountCode;
	}

	public void setUserAccountCode(String userAccountCode) {
		this.userAccountCode = userAccountCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "WqkUserLoginDO [userAccountCode=" + userAccountCode
				+ ", password=" + password + "]";
	}

}
