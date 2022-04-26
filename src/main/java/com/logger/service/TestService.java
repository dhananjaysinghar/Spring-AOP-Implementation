package com.logger.service;

import com.logger.annotations.HandleException;
import com.logger.annotations.MeasureTimeExecution;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    @HandleException
    public void handleEx() {
        throw new RuntimeException("Unknown error occurred");
    }

    @MeasureTimeExecution
    public String serve() {
        ((TestService) AopContext.currentProxy()).serve1();
        return "Hi DJ";
    }

    @MeasureTimeExecution
    public String serve1() {
        return "Hello";
    }


}
