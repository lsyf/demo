package com.example.sentinel.biz;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HomeBiz {

    @SentinelResource(value = "sayHello")
    public void sayHello(String time) {
        log.info("sayHello: " + time);
    }

}
