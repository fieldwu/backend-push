package com.basic.backend.push.biz.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 【登陆】Controller
 * 
 * @author Field
 * @version 1.0
 */
@Controller
public class IndexController {

	/**
	 * 默认讲根目录重定向到swagger-ui上
	 */
	@RequestMapping("/api")
	public void swaggerUI(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/do_not_delete/health_check")
	@ResponseBody
	public String healthCheck() {
		return "hjhealthcheck";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	/**
	 * 尽管 logical = Loogical.OR, Shiro认证的时候没有短路校验，如果RequiresPermissions配置几个权限就会认证几次。
	 * 出于性能考虑RequiresPermissions建议只配一个权限项。
	 */
//	@RequiresPermissions(value={PERM_PRE+"app1", BackendAuthConstant.ROOT_PERM}, logical = Logical.OR)
//	@RequiresPermissions(value={PermTag.SRC_PRE+"app"})
	@RequestMapping(value = "/auth/app")
	public String app() {
		return "app";
	}

//	@RequiresPermissions(value={PermTag.SRC_PRE+"menu"})
	@RequestMapping(value = "/auth/menu")
	public String menu() {
		return "menu";
	}

//	@RequiresPermissions(value={PermTag.SRC_PRE+"user"})
	@RequestMapping(value = "/auth/user")
	public String user() {
		return "user";
	}

//	@RequiresPermissions(value={PermTag.SRC_PRE+"role"})
	@RequestMapping(value = "/auth/role")
	public String role() {
		return "role";
	}

//	@RequiresPermissions(value={PermTag.SRC_PRE+"group"})
	@RequestMapping(value = "/auth/group")
	public String group() {
		return "group";
	}

	@RequestMapping(value = "/unauthorized")
	public String unauthorized(HttpServletResponse res) throws IOException {
		return "unauthorized";
	}

	@RequestMapping(value = "/403")
	public String forbidden(HttpServletResponse res) throws IOException {
		return "unauthorized";
	}

	@RequestMapping(value = "/demo")
	public String demo() {
		return "demo";
	}

}
