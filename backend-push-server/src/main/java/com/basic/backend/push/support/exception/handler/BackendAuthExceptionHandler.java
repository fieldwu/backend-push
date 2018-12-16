package com.basic.backend.push.support.exception.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.basic.backend.push.model.dto.CommmonResponseDTO;
import com.basic.backend.push.support.exception.BackendAuthException;

/**
 * 异常处理器
 * 
 * @author Field
 */
@RestControllerAdvice
public class BackendAuthExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(BackendAuthException.class)
	public CommmonResponseDTO handleRRException(BackendAuthException e) {
		logger.error(e.getMessage(), e);
		CommmonResponseDTO r = new CommmonResponseDTO();
		r.put("status", e.getStatus());
		r.put("message", e.getMessage());
		return r;
	}

	/**
	 * 处理 MethodArgumentNotValidException
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommmonResponseDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);
		BeanPropertyBindingResult bindingResult = (BeanPropertyBindingResult) e.getBindingResult();
		List<ObjectError> errorList = bindingResult.getAllErrors();

		StringBuffer buffer = new StringBuffer();
		if (!CollectionUtils.isEmpty(errorList)) {
			for (int index = 0; index < errorList.size(); index++) {
				ObjectError error = errorList.get(index);
				System.out.println(error.getClass().getName());
				if (error instanceof FieldError) {
					FieldError fieldError = (FieldError) error;
					buffer.append("[").append(fieldError.getObjectName()).append(".").append(fieldError.getField())
							.append(fieldError.getDefaultMessage())
//					.append(":当前为").append(fieldError.getRejectedValue())
					;
				} else {
					buffer.append(error.getCodes()[0]);
				}
				if (index != errorList.size() - 1) {
					buffer.append("]; ");
				} else {
					buffer.append("]");
				}
			}
		}

		return CommmonResponseDTO.error(400, buffer.toString());
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public CommmonResponseDTO handleDuplicateKeyException(DuplicateKeyException e) {
		logger.error(e.getMessage(), e);
		return CommmonResponseDTO.error("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public CommmonResponseDTO handleException(Exception e) {
		logger.error(e.getMessage(), e);
		return CommmonResponseDTO.error();
	}
}
