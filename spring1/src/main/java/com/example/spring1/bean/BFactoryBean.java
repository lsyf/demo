package com.example.spring1.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

@Slf4j
public class BFactoryBean implements FactoryBean<BBean> {

    @Override
    public BBean getObject() throws Exception {
        return new BBean();
    }

    @Override
    public Class<?> getObjectType() {
        return BBean.class;
    }
}
