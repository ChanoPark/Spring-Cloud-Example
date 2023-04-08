package com.example.userservice.dto;

import com.example.userservice.vo.RequestUser;
import lombok.Getter;

import java.util.Date;

@Getter
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;

    public UserDto(RequestUser requestUser) {
        this.email = requestUser.getEmail();
        this.pwd = requestUser.getPwd();
        this.name = requestUser.getName();
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
