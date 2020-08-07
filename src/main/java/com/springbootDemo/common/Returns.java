package com.springbootDemo.common;

import java.io.Serializable;
import java.util.HashMap;

import com.springbootDemo.login.tool.LoginTool;

/**
 * 返回客户端信息公用类
 * 
 * @author 王钦凯
 * @version 1.0
 * 
 */
public class Returns extends HashMap<String, Object> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Returns() {
		this.put("code", LoginTool.CODE);
		this.put("success", true);
		this.put("msg", "操作成功");
	}

	/**
	 * 成功
	 * 
	 * @param code
	 * @param success
	 * @param msg
	 * @return
	 */
	public static Returns ok(Integer code, Boolean success, String msg) {
		Returns r = new Returns();
		r.put("code", code);
		r.put("success", success);
		r.put("msg", msg);
		return r;
	}

	/**
	 * 操作成功
	 * 
	 * @return
	 */
	public static Returns ok() {
		return new Returns();
	}

	/**
	 * 操作失败
	 * 
	 * @return
	 */
	public static Returns error() {
		Returns r = new Returns();
		r.put("code", LoginTool.ERRCODE);
		r.put("success", false);
		r.put("msg", "操作失败");
		return r;
	}

	/**
	 * 操作失败
	 * 
	 * @param code
	 * @param success
	 * @param msg
	 * @return
	 */
	public static Returns error(Integer code, Boolean success, String msg) {
		Returns r = new Returns();
		r.put("code", code);
		r.put("success", success);
		r.put("msg", msg);
		return r;
	}

	/**
	 * 判断当前操作是否成功
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return (boolean) this.get("success");
	}

	@Override
	public Returns put(String key, Object value) {
		super.put(key, value);
		return this;
	}

}
