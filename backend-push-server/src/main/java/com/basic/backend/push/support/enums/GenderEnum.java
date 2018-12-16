package com.basic.backend.push.support.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别: M 男; F 女
 * 
 * @author Field
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {

	男("M", "男"),

	女("F", "女"),

	;

	private String code;
	private String desc;

	/**
	 * 根据code获取描述信息
	 */
	public static String getDescByCode(String code) {
		for (GenderEnum value : GenderEnum.values()) {
			if (value.getCode().equals(code)) {
				return value.getDesc();
			}
		}
		return code;
	}
}
