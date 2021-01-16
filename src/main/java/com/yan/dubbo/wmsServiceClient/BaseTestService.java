package com.yan.dubbo.wmsServiceClient;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 13:48
 * DESC:
 */
public class BaseTestService {

    public static <T> T getBean(Class<T> clazz, String beanName) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        ctx.start();
        return (T) ctx.getBean(beanName, clazz);
    }
}
