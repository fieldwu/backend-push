package com.basic.backend.push.support.enums;

/**
 * 登录策略枚举
 * 
 * @author Field
 */
public enum LoginPolicy {

	/**
	 * 用户名登录
	 */
	USERNAME,

	/**
	 * EMAIL+用户类型登录
	 */
	EMAIL_USERTYPE,

	/**
	 * 手机号+用户类型登录
	 */
	PHONE_USERTYPE,

	/**
	 * 自动判断
	 */
	AUTO;
}
