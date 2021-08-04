package com.ding.user.controller;

import com.ding.user.entity.UmsAdmin;
import com.ding.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public String discoveryService(){
        return restTemplate.getForObject("http://study-goods/goods/dis",String.class);

    }

    /**
     * 注册用户
     * @return
     */
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(@RequestBody UmsAdmin userAdmin){
        userService.registerUser(userAdmin);
        return "插入成功";
    }

    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    public List<UmsAdmin> selectUser(){
        List<UmsAdmin> userAdmins = userService.selectUser();
        System.out.println(userAdmins);
        return userAdmins;
    }

}
