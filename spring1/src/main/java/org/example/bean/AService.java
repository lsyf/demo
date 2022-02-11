package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AService {

    @Autowired
    BService bService;

    @Autowired
    AService aService;

    public void print() {
        System.out.println("AService print");
    }

}
