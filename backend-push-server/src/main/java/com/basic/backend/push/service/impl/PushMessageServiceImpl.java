package com.basic.backend.push.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.basic.backend.push.api.MessageTools;
import com.basic.backend.push.model.dto.push.SendMessageReq;
import com.basic.backend.push.service.PushMessageService;

public class PushMessageServiceImpl implements PushMessageService {
	
	private static Logger LOG = LoggerFactory.getLogger(PushMessageServiceImpl.class);

	@Override
	public void pushMessage(SendMessageReq sendMessageReq) {
		String content = sendMessageReq.getContent();
		String cluster = sendMessageReq.getCluster();
		MessageTools.sendMsgByNickName(content, cluster);
	}
}
