package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class TransactionalBean {


    @Transactional
    public void print() {
        log.info("TransactionalBean print");
    }

}
