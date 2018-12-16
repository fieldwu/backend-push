package com.basic.backend.push.biz.facade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 【应用】服务
 * 
 * @author Field
 * @version 1.0
 */
@RestController
@Api(tags = { "【应用】服务" })
@RequestMapping("/api/app")
public class AppFacade extends BaseFacade {

}
