package com.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy=true)
public class CommonLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonLoggerApplication.class, args);
	}

}
