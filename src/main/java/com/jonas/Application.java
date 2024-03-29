package com.jonas;

import com.jonas.bean.BeanPostProcessorBean;
import com.jonas.bean.UserBean;
import com.jonas.controller.UserController;
import com.jonas.feature.aware.AllAwareInterface;
import com.jonas.feature.aware.MyEmbeddedValueResolverAware;
import com.jonas.feature.factorybean.UserFactoryBean;
import com.jonas.feature.transaction.domain.Player;
import com.jonas.feature.transaction.service.PlayerService;
import com.jonas.listener.event.LogEvent;
import com.jonas.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.sql.Timestamp;

@EnableAsync   //启用异步调用
@ComponentScan
public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.testBeanPostProcessor();
    }

    /**
     * 测试 BeanPostProcessor
     */
    public void testBeanPostProcessor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        BeanPostProcessorBean bean = context.getBean(BeanPostProcessorBean.class);
    }

    public void testEmbeddedValueResolverAware() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MyEmbeddedValueResolverAware aware = context.getBean(MyEmbeddedValueResolverAware.class);
        System.out.println(aware.resolve("${logging.file}"));
    }

    public void testAware() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        AllAwareInterface awareInterface = context.getBean(AllAwareInterface.class);
    }

    public void testTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        PlayerService playerService = (PlayerService) context.getBean("playerService");
        Player player = new Player("Jonas", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        playerService.save(player);
    }

    /**
     * 测试xml配置获取bean
     */
    public void testXmlInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        UserBean userBean = (UserBean) context.getBean("userBean");
        System.out.println(userBean);
//        User customUser = (User) context.getBean("customUserBean");
        UserFactoryBean customUser = (UserFactoryBean) context.getBean("&customUserBean");
        System.out.println(customUser);
//        customUser.init();
    }

    /**
     * 测试注解配置获取bean
     */
    public void testAnnotationInject() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserService userService = context.getBean(UserService.class);
        UserBean userBean = userService.getUser();
        userService.printUserInfo(userBean);
        //发布事件
        context.publishEvent(new LogEvent(context, userBean));
    }

    /**
     * 测试Autowired注解
     */
    public void testAutowired() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserController userController = context.getBean(UserController.class);
        UserBean userBean = userController.getUser();
        userController.printUserInfo(userBean);
    }
}
