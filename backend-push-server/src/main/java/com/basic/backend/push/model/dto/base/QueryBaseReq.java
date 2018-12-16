package com.basic.backend.push.model.dto.base;

import java.util.Date;

import com.basic.backend.push.model.dto.BaseDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询基础请求对象
 * 
 * @author Field
 */
@Getter
@Setter
public class QueryBaseReq extends BaseDTO {

	private static final long serialVersionUID = -6644731421790474623L;

	@ApiModelProperty(value = "创建开始时间", required = true)
	private Date createTimeStart;

	@ApiModelProperty(value = "创建结束时间", required = true)
	private Date createTimeEnd;

	@ApiModelProperty(value = "页码", required = true)
	private Integer pageNum = 0;

	@ApiModelProperty(value = "页大小", required = true)
	private Integer pageSize = 0;
}