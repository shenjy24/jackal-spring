package com.jonas.controller;

import com.jonas.bean.User;
import com.jonas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public User getUser() {
        return userService.getUser();
    }

    public void printUserInfo(User user) {
        userService.printUserInfo(user);
    }
}
