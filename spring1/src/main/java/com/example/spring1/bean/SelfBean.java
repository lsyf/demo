package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class SelfBean implements InitializingBean {

    @Autowired
    SelfBean selfBean;

    @PostConstruct
    public void print() {
        log.info("SelfBean print:  self={}", selfBean);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("SelfBean print:  self={}", selfBean);
    }
}
