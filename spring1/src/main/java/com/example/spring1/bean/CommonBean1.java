package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommonBean1 {

    @Autowired
    CommonBean2 commonBean2;

    public void print() {
        log.info("CommonBean1 print");
    }

}
