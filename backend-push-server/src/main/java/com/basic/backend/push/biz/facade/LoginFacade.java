package com.basic.backend.push.biz.facade;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.backend.push.core.Core;
import com.basic.backend.push.service.ILoginService;
import com.basic.backend.push.service.impl.LoginServiceImpl;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * 【登陆】服务
 * 
 * @author Field
 * @version 1.0
 */
@RestController
@Api(tags = { "【登陆】服务" })
@RequestMapping("/api")
@Slf4j
public class LoginFacade {
	private static Logger LOG = LoggerFactory.getLogger(LoginFacade.class);
	private ILoginService loginService = new LoginServiceImpl();
	private static Core core = Core.getInstance();

	@RequestMapping({ "/login" })
	@ResponseBody
	public void loginPush(HttpServletRequest request) {
		AsyncContext async = request.startAsync();
		loginService.login(async);
	}
}