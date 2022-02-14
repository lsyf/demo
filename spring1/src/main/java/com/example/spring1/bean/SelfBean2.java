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

    @Transactional
    @PostConstruct
    public void print() {
        a = 2;
        System.out.println(this.a);
        log.info("SelfBean2 print");
        System.out.println(selfBean2.a);
    }

}
