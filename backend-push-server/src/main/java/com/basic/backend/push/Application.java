package com.basic.backend.push;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot启动类
 * 
 * @author Field
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.basic.backend.push")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
