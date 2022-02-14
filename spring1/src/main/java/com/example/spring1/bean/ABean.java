package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ABean {
    @Value("${demo.testValue}")
    int testValue;


    public void print() {
        log.info("ABean print");
    }

}
