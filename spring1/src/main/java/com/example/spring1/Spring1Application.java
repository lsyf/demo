package com.example.spring1;

import com.example.spring1.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAsync
@Slf4j
public class Spring1Application {

    @Autowired
    BBean bBean;
    @Autowired
    SelfBean2 selfBean2;
    @Autowired
    SelfBean3 selfBean3;
    @Autowired
    CommonBean1 commonBean1;
    @Autowired
    CommonBean2 commonBean2;
    @Autowired
    SelfBean selfBean;
    @Autowired
    ABean aBean;
    @Autowired
    TransactionalBean transactionalBean;
    @Autowired
    AsyncBean asyncBean;

    @PostConstruct
    public void print() {
        selfBean.print();
        selfBean2.print();
        selfBean3.print();
        commonBean1.print();
        commonBean2.print();
        aBean.print();
        transactionalBean.print();
        asyncBean.print();
        bBean.print();
    }

    public static void main(String[] args) {
        SpringApplication.run(Spring1Application.class, args);
        System.exit(1);
    }


}
