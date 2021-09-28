package com.jonas;

import com.jonas.bean.User;
import com.jonas.controller.UserController;
import com.jonas.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.testAutowired();
    }

    /**
     * 测试xml配置获取bean
     */
    public void testGetBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        User user = (User) context.getBean("userBean");
        System.out.println(user);
    }

    /**
     * 测试注解配置获取bean
     */
    public void testAutoInject() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.getUser();
        userService.printUserInfo(user);
    }

    /**
     * 测试Autowired注解
     */
    public void testAutowired() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserController userController = context.getBean(UserController.class);
        User user = userController.getUser();
        userController.printUserInfo(user);
    }
}
