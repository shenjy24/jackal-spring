package com.jonas.service.impl;

import com.jonas.bean.UserBean;
import com.jonas.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

    @Override
    public UserBean getUser() {
        return (UserBean) context.getBean("userBean");
    }

    @Override
    public void printUserInfo(UserBean userBean) {
        System.out.println("玩家信息：" + userBean);
    }
}
