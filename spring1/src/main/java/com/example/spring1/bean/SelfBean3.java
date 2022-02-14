package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SelfBean3 {

    @Autowired
    @Lazy
    SelfBean3 selfBean3;


    @Async
    public void print() {
        log.info("SelfBean3 print");
    }

}
