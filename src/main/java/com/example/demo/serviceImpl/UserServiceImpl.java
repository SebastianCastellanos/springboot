package com.example.demo.serviceImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public String getUserName(String username) { return userMapper.getUserName(username); }

    @Override
    public String getPassWord(String password) {
        return userMapper.getPassWord(password);
    }

    @Override
    public int userRegister(String username, String password) {
        return userMapper.userRegister(username,password);
    }
}
