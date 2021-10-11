package com.jonas;

import com.jonas.bean.User;
import com.jonas.controller.UserController;
import com.jonas.listener.event.LogEvent;
import com.jonas.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync   //启用异步调用
@ComponentScan
public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.testXmlInject();
    }

    /**
     * 测试xml配置获取bean
     */
    public void testXmlInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        User user = (User) context.getBean("userBean");
        System.out.println(user);
         User customUser = (User) context.getBean("customUserBean");
//        UserFactoryBean customUser = (UserFactoryBean) context.getBean("&customUserBean");
        System.out.println(customUser);
    }

    /**
     * 测试注解配置获取bean
     */
    public void testAnnotationInject() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.getUser();
        userService.printUserInfo(user);
        //发布事件
        context.publishEvent(new LogEvent(context, user));
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
