package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Slf4j
public class SelfBean2 {

    public int a = 1;

    @Autowired
    SelfBean2 selfBean2;

    @PostConstruct
    public void init() {
        a = 2;
    }

    @Transactional
    public void print() {
        log.info("SelfBean2 print");
        System.out.println(this.a);
        System.out.println(selfBean2.a);
    }

}
