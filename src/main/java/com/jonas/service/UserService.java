package com.jonas.service;

import com.jonas.bean.User;

public interface UserService {
    User getUser();
    void printUserInfo(User user);
}
