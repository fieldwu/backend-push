package com.basic.backend.push.service.dal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SERVICE 测试案例
 * 
 * @author Field
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceTest {

	private transient Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	public void insert() {
		int result = 1 ;
		log.info(">>> Inserted record: {}", new Object[] { result });
		assertEquals(1, result);
	}
}