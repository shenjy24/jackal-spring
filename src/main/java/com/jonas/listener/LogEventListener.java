package com.jonas.listener;

import com.jonas.listener.event.LogEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件处理于发布事件线程中处理，即是同步处理
 */
@Component
public class LogEventListener implements ApplicationListener<LogEvent> {
    @Async      //使用异步处理
    @Override
    public void onApplicationEvent(LogEvent event) {
        System.out.println("日志记录: " + event.getUser());
    }
}
