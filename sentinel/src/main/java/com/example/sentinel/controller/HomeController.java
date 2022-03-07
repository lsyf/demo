package com.example.sentinel.controller;

import com.example.sentinel.biz.HomeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HomeController {

    @Autowired
    HomeBiz homeBiz;

    @GetMapping
    public String test() {
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        homeBiz.sayHello(time);
        return time;
    }
}
