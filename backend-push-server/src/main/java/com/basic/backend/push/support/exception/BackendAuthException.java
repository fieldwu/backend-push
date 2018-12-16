package com.basic.backend.push.support.exception;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.basic.backend.push.support.enums.ExceptionEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 * 
 * @author Field
 */
@Getter
@Setter
@AllArgsConstructor
public class BackendAuthException extends RuntimeException {

	private static final long serialVersionUID = -9157638260378152238L;

	private int status = 0;
	private String message;

	/**
	 * 以异常信息为参数的构造函数
	 * 
	 * @param ee
	 */
	public BackendAuthException(ExceptionEnum ee) {
		this.status = ee.getCode();
		this.message = ee.getDesc();
	}

	/**
	 * 以异常信息为参数的构造函数
	 * 
	 * @param ee
	 */
	public BackendAuthException(ExceptionEnum ee, String appendMessage) {
		this.status = ee.getCode();
		this.message = ee.getDesc() + ":" + appendMessage;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
