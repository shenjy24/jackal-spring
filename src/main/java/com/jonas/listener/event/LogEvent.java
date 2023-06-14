package com.jonas.listener.event;

import com.jonas.bean.UserBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class LogEvent extends ApplicationContextEvent {

    private UserBean userBean;

    public LogEvent(ApplicationContext source, UserBean userBean) {
        super(source);
        this.userBean = userBean;
    }

    public UserBean getUser() {
        return userBean;
    }
}
