package com.ding.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UmsAdmin {
    private BigInteger id;
    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickName;
    private String note;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginTime;
    private Integer status;
}
