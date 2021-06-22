package com.example.demo.service;

public interface UserService {

    //查询用户名
    String getUserName(String username);
    //查询密码
    String getPassWord(String password);
    //用户注册
    int userRegister(String username, String password);
}
