package com.example.demo.serviceImpl;

import com.example.demo.entity.RespPageBean;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectUserList(UserInfo userInfo){
        return userInfoMapper.selectUserList(userInfo);
    }

    @Override
    public int deleteUserInfo(Integer id) {
        return userInfoMapper.deleteUserInfo(id);
    }

    @Override
    public List<UserInfo> selectInfoByName(String name) {
        return userInfoMapper.selectInfoByName(name);
    }

    @Override
    public List<UserInfo> selectInfoByAddress(String address) {
        return userInfoMapper.selectInfoByAddress(address);
    }

    @Override
    public List selectPage(Integer page, Integer size) {
        UserInfo userInfo = new UserInfo();
        List<UserInfo> userInfoList = userInfoMapper.selectUserList(userInfo);
        List data = PageHelper.startPage(page,size);
        return userInfoMapper.selectUserList(userInfo);
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoMapper.addUserInfo(userInfo);
    }
}
