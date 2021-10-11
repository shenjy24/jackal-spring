package com.jonas.feature.factorybean;

import com.jonas.bean.User;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FactoryBean可以自定义bean加载逻辑
 */
@Data
public class UserFactoryBean implements FactoryBean<User> {

    //接受逗号分隔符设置属性信息
    private String userInfo;
    private String format = "yyyy-MM-dd";

    @Override
    public User getObject() throws Exception {
        String[] info = userInfo.split(",");
        if (3 != info.length) {
            return null;
        }
        User user = new User();
        user.setUserId(Integer.parseInt(info[0]));
        user.setUserName(info[1]);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        user.setBirthDate(sdf.parse(info[2]));
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
