package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BService {

    @Autowired
    AService aService;

    public void print() {
        System.out.println("BService print");
    }
}
