package com.basic.backend.push.model.dto.base;

import java.util.ArrayList;
import java.util.List;

import com.basic.backend.push.model.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询列表响应基类
 * 
 * @author Field
 */
@Getter
@Setter
public class QueryBaseRes<T> extends BaseDTO {

	private static final long serialVersionUID = -8508672646298513700L;

	private Long total;
	private Integer pages;
	private List<T> resultList = new ArrayList<>();

}