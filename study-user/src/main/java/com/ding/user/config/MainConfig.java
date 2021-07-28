package com.ding.user.config;

import com.ding.user.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public void getUser(){
        User user = new User();
        user.setId("1111")
                .setAge(6)
                .setUserId("123456")
                .setUserName("小小小")
                ;
        System.out.println();
    }
}
