package com.jonas.service;

import com.jonas.bean.UserBean;

public interface UserService {
    UserBean getUser();
    void printUserInfo(UserBean userBean);
}
