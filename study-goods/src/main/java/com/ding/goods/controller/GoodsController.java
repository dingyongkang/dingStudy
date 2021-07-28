package com.ding.goods.controller;

import com.alibaba.fastjson.JSON;
import com.ding.goods.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @RequestMapping(value = "/dis",method = RequestMethod.GET)
    public String goods(){
        return "我是商品";
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setAge(null);
        user.setUserName(null);
        users.add(user);
        //users.add(null);
        Map<String, Object> map = new HashMap<>();
        users.stream().forEach(x -> {
            map.put(x.getAge(), JSON.toJSONString(x));
        });
        System.out.println(map.get(0));
    }
}
