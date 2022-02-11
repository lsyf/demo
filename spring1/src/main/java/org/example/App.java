package org.example;


import org.example.bean.AService;
import org.example.bean.BService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("org.example");
        ctx.refresh();

        AService aService = ctx.getBean(AService.class);
        aService.print();

        BService bService = ctx.getBean(BService.class);
        bService.print();
    }
}
