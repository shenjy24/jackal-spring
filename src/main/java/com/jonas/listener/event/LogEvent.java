package com.jonas.listener.event;

import com.jonas.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class LogEvent extends ApplicationContextEvent {

    private User user;

    public LogEvent(ApplicationContext source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
