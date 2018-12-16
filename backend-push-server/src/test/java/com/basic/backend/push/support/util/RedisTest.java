package com.basic.backend.push.support.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.basic.backend.push.support.util.RedisUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void test() {
		String user = "zhangsan";
		redisUtils.set("user", user);
		user = redisUtils.get("user", String.class);
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
}
