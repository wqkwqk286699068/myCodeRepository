package com.springbootDemo.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 自定义运行异常
 * 
 * @author wqk
 * @version 1.0
 * 
 */
public class MyRunException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 信息
	 */
	private String msg;
	private int code = 500;

	public MyRunException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public MyRunException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public MyRunException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public MyRunException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 获取堆栈信息保存job日志
	 * 
	 * @param t
	 * @return
	 */
	public static String getErrmessage(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		t.printStackTrace(new PrintWriter(stringWriter, true));
		return stringWriter.getBuffer().toString();
	}

}
