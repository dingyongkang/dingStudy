package com.ding.user.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
public class User {
    private String id;
    private String userId;
    private String userName;
    private Integer age;
    private String passWord;
}
