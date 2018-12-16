package com.basic.backend.push.service;

import com.basic.backend.push.model.dto.push.SendMessageReq;

/**
 * 登陆服务接口
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月13日 上午12:07:21
 * @version 1.0
 *
 */
public interface PushMessageService {

	/**
	 * 发送信息
	 */
	void pushMessage(SendMessageReq sendMessageReq);

}
