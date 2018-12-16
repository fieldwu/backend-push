package com.basic.backend.push.model.dto.push;

import org.hibernate.validator.constraints.NotBlank;

import com.basic.backend.push.model.dto.base.QueryBaseReq;

import lombok.Getter;
import lombok.Setter;

/**
 * 获取访问权限信息 请求DTO
 * 
 * @author Field
 */
@Getter
@Setter
public class SendMessageReq extends QueryBaseReq {

	private static final long serialVersionUID = 3692732423871201695L;

	/**
	 * 应用代码
	 */
	@NotBlank
	private String appCode;
	/**
	 * 群
	 */
	@NotBlank
	private String cluster;
	/**
	 * 发送群下人员
	 */
	@NotBlank
	private String names;
	/**
	 * 企业代码
	 */
	@NotBlank
	private String enterprise;
	/**
	 * 发送内容
	 */
	@NotBlank
	private String content;

}
