package com.basic.backend.push.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 相关配置文件
 * 
 * @author Field
 */
@Configuration
@EnableSwagger2
//@ConfigurationProperties
public class Swagger2Config {

	@Value("${swagger.enable}")
	private boolean enable;

	@Value("${swagger.basePackage}")
	private String basePackage;

	@Value("${swagger.title}")
	private String title;

	@Value("${swagger.description}")
	private String description;

	@Value("${swagger.version}")
	private String version;

	@Value("${swagger.contact}")
	private String contact;

	@Value("${swagger.contact.email}")
	private String contactEmail;

	@Bean
	public Docket Docket() {
		return new Docket(DocumentationType.SWAGGER_2).enable(enable).apiInfo(initApiInfo()).groupName("default")
//                .pathMapping("/api")//每个URL前面会带上的前缀base，最终调用接口后会和paths拼接在一起
				.genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET,customerResponseMessage())
				.forCodeGeneration(true).select().apis(RequestHandlerSelectors.basePackage(basePackage))
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any())
				.build();
	}

	/*
	 * @Bean public Docket Docket_Test() { return new
	 * Docket(DocumentationType.SWAGGER_2) .enable(enable) .apiInfo(initApiInfo())
	 * .groupName("test")
	 * .pathMapping("/api")//每个URL前面会带上的前缀base，最终调用接口后会和paths拼接在一起
	 * .genericModelSubstitutes(DeferredResult.class)
	 * .useDefaultResponseMessages(false) //
	 * .globalResponseMessage(RequestMethod.GET,customerResponseMessage())
	 * .forCodeGeneration(true) .select()
	 * .apis(RequestHandlerSelectors.basePackage(basePackage))
	 * .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
	 * .paths(PathSelectors.any()) .build(); }
	 */

	private ApiInfo initApiInfo() {
		Contact swaggerContact = new Contact(contact + " [" + contactEmail + "]", null, contactEmail);
		return new ApiInfoBuilder().title(title)
//                .description(description)
				.contact(swaggerContact).version(version).build();
	}
}
