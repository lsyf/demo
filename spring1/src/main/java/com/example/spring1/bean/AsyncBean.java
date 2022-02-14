package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncBean {


    @Async
    public void print() {
        log.info("AsyncBean print");
    }

}
