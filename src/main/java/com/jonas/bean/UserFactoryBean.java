package com.jonas.bean;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean可以自定义bean加载逻辑
 */
@Data
public class UserFactoryBean implements FactoryBean<User> {

    //接受逗号分隔符设置属性信息
    private String userInfo;

    @Override
    public User getObject() throws Exception {
        String[] info = userInfo.split(",");
        if (2 != info.length) {
            return null;
        }
        User user = new User();
        user.setUserId(Integer.parseInt(info[0]));
        user.setUserName(info[1]);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
