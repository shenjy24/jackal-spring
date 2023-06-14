package com.jonas;

import com.jonas.bean.UserBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean.xml"})
public class ApplicationTest {

    @Autowired
    @Qualifier("userBean")
    private UserBean autowiredUserBean;

    /**
     * 测试xml配置获取bean
     */
    @Test
    public void testXmlInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        UserBean userBean = (UserBean) context.getBean("userBean");
        System.out.println(userBean);
    }

    /**
     * 测试自动注入获取bean
     */
    @Test
    public void testAutowired() {
        Assert.assertNotNull(autowiredUserBean);
        System.out.println(autowiredUserBean);
    }
}
