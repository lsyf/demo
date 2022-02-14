package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommonBean2 {

    @Autowired
    CommonBean1 commonBean1;

    public void print() {
        log.info("CommonBean2 print");
    }


}
