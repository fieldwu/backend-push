package com.basic.backend.push.support.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态
 * 
 * @author Field
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

	DISABLE("0", "无效"),

	ENABLE("1", "有效"),

	REFUSE("2", "拒绝"),

	FORBIDDEN("3", "禁用"),

	REMOVE("4", "删除"),;

	private String code;
	private String desc;

	/**
	 * 根据code获取描述信息
	 */
	public static String getDescByCode(String code) {
		for (StatusEnum value : StatusEnum.values()) {
			if (value.getCode().equals(code)) {
				return value.getDesc();
			}
		}
		return code;
	}
}
