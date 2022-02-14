package com.example.spring1;

import com.example.spring1.bean.BFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "bBean")
    public BFactoryBean bFactoryBean() {
        return new BFactoryBean();
    }

}
