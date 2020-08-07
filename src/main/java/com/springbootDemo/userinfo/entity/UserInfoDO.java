package com.springbootDemo.userinfo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 * 
 * @author wqk
 * 
 */
public class UserInfoDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private String userAccountCode;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 英文名
	 */
	private String EnglishName;
	/**
	 * 中文名
	 */
	private String ChineseName;
	/**
	 * 跳转路径
	 */
	private String url;
	/**
	 * 等级
	 */
	private String level;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 操作
	 */
	private String operation;

	public String getEnglishName() {
		return EnglishName;
	}

	public void setEnglishName(String englishName) {
		EnglishName = englishName;
	}

	public String getChineseName() {
		return ChineseName;
	}

	public void setChineseName(String chineseName) {
		ChineseName = chineseName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

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
		return "UserInfoDO [userAccountCode=" + userAccountCode + ", password="
				+ password + ", EnglishName=" + EnglishName + ", ChineseName="
				+ ChineseName + ", url=" + url + ", level=" + level
				+ ", state=" + state + ", createDate=" + createDate
				+ ", operation=" + operation + "]";
	}

}
