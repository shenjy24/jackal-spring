package com.jonas.controller;

import com.jonas.bean.UserBean;
import com.jonas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserBean getUser() {
        return userService.getUser();
    }

    public void printUserInfo(UserBean userBean) {
        userService.printUserInfo(userBean);
    }
}
