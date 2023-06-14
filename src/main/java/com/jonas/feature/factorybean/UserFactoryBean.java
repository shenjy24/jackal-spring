package com.jonas.feature.factorybean;

import com.jonas.bean.UserBean;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;

/**
 * FactoryBean可以自定义bean加载逻辑
 */
@Data
public class UserFactoryBean implements FactoryBean<UserBean> {

    //接受逗号分隔符设置属性信息
    private String userInfo;
    private String format = "yyyy-MM-dd";

    @Override
    public UserBean getObject() throws Exception {
        String[] info = userInfo.split(",");
        if (3 != info.length) {
            return null;
        }
        UserBean userBean = new UserBean();
        userBean.setUserId(Integer.parseInt(info[0]));
        userBean.setUserName(info[1]);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        userBean.setBirthDate(sdf.parse(info[2]));
        return userBean;
    }

    @Override
    public Class<?> getObjectType() {
        return UserBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
