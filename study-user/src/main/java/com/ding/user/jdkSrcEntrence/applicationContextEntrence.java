package com.ding.user.jdkSrcEntrence;

import com.ding.user.config.MainConfig;
import com.ding.user.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class applicationContextEntrence {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for(String beanName: beanDefinitionNames){
            System.out.println(beanName);
        }
    }
}
