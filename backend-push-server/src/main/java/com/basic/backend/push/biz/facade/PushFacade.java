package com.basic.backend.push.biz.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basic.backend.push.model.dto.push.SendMessageReq;
import com.basic.backend.push.service.PushMessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 【组】服务
 * 
 * @author Field
 * @version 1.0
 */
@RestController
@Api(tags = { "【组】服务" })
@RequestMapping("/api/push")
public class PushFacade extends BaseFacade {
	
	@Autowired
	PushMessageService pushMessageService;
	
	/**
	 * 内部管理页面 新增
	 */
	@ApiOperation(value = "推送信息", notes = "")
	@RequestMapping(value = "/pushMessage", method = RequestMethod.POST)
	public void pushMessage(@RequestBody SendMessageReq sendMessageReq) {
		pushMessageService.pushMessage(sendMessageReq);
	}
}
