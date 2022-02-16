package com.example.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.CharBuffer;
import java.util.concurrent.TimeUnit;

@RestController
public class HomeController {

    @GetMapping("test")
    public String index() throws InterruptedException {
        System.out.println(1);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(2);

//        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return CharBuffer.allocate(1000 * 1000).toString().replace('\0', '1');
    }

}
