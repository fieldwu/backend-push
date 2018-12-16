package com.basic.backend.push.model.dto.base;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.basic.backend.push.model.dto.BaseDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 删除DTO请求
 * 
 * @author Field
 */
@Getter
@Setter
public class RemoveBaseReq extends BaseDTO {

	private static final long serialVersionUID = 7759581723611758172L;

	@NotEmpty(message = "ID集合 不能为空")
	@ApiModelProperty(value = "ID集合", required = true)
	private List<Long> idList;

}