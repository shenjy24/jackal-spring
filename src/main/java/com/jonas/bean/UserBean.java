package com.jonas.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private int userId;
    private String userName;
    private Date birthDate;

    public void init() {
        System.out.println("start init user");
        System.out.println("userId:" + userId);
        System.out.println("userName:" + userName);
        System.out.println("birthDate:" + birthDate);
        System.out.println("finish init user");
    }
}
