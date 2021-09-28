package com.jonas;

import com.jonas.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        User user = (User) context.getBean("userBean");
        System.out.println(user);
    }
}
