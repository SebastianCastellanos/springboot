package com.example.demo.mapper;

public interface UserMapper {

    String getUserName(String username);

    String getPassWord(String password);

    int userRegister(String username, String password);
}
