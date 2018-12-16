package com.basic.backend.push.model.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用 返回数据 DTO
 * 
 * @author Field
 */
public class CommmonResponseDTO extends HashMap<String, Object> {

	private static final long serialVersionUID = 3553779371863664184L;
	private static final String STATUS = "status";
	private static final String MESSAGE = "message";
	private static final String DATA = "data";

	private static final int ERROR_CODE = 50000;
	private static final int UN_AUTHENTICATED = 40101;// 40101
	private static final int UN_AUTHORIZED = 40102;//

	/**
	 * HTTP 401 错误 - 未授权： (Unauthorized) 您的Web服务器认为，客户端发送的 HTTP 数据流是正确的，但进入网址 (URL)
	 * 资源 ， 需要用户身份验证
	 * 
	 * 系统定义： 40101 为 未认证 40102 为 未授权
	 */

	public CommmonResponseDTO() {
		put(STATUS, 0);
//		put(MESSAGE, "");
	}

	/**
	 * 错误响应
	 */
	public static CommmonResponseDTO error() {
		return error(ERROR_CODE, "未知异常，请联系管理员");
	}

	/**
	 * 未授权响应
	 */
	public static CommmonResponseDTO unAuthticated() {
		return error(UN_AUTHENTICATED, "访问拒绝,请进行登陆认证");
	}

	/**
	 * 错误响应
	 */
	public static CommmonResponseDTO unAuthrized() {
		return error(UN_AUTHORIZED, "访问拒绝,请进行登陆认证");
	}

	/**
	 * 错误响应
	 */
	public static CommmonResponseDTO error(String msg) {
		return error(ERROR_CODE, msg);
	}

	/**
	 * 错误响应
	 */
	public static CommmonResponseDTO error(int code, String msg) {
		CommmonResponseDTO r = new CommmonResponseDTO();
		r.put(STATUS, code);
		r.put(MESSAGE, msg);
		return r;
	}

	/**
	 * 正确响应
	 */
	public static CommmonResponseDTO ok(String msg) {
		CommmonResponseDTO response = new CommmonResponseDTO();
		response.put(MESSAGE, msg);
		return response;
	}

	/**
	 * 正确响应
	 */
	@Deprecated
	public static CommmonResponseDTO ok(Map<String, Object> map) {
		CommmonResponseDTO r = new CommmonResponseDTO();
		r.putAll(map);
		return r;
	}

	/**
	 * 正确响应
	 */
	public static CommmonResponseDTO ok() {
		return new CommmonResponseDTO();
	}

	/**
	 * 向响应中PUT对象
	 */
	public CommmonResponseDTO put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	/**
	 * 响应数据
	 */
	public CommmonResponseDTO data(Object... values) {
		if (values.length == 1) {
			super.put(DATA, values[0]);
		} else if (values.length > 1) {
			for (int i = 0; i < values.length; i++) {
				super.put(DATA + (i + 1), values[i]);
			}
		}
		return this;
	}
}
