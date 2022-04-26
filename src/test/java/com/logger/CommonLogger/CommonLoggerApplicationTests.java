package com.logger.CommonLogger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.logger.service.TestService;

@SpringBootTest
public class CommonLoggerApplicationTests {

	@Autowired
	private TestService service;
	
	@Test
	public void runTests() {
		service.serve();
		service.serve1();
	}

	@Test
	public void testError(){
		Assertions.assertThrows(RuntimeException.class, () -> service.handleEx());
	}
}
