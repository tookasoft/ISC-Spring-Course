package com.example;

import com.example.bean.Member;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanRequiredUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        var member = context.getBean(Member.class);

        System.out.println(member);
    }
}
