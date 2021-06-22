package com.example.demo.service;

import com.example.demo.entity.RespPageBean;
import com.example.demo.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    /**
     * 信息列表
     * @param
     * @return
     */
    List<UserInfo> selectUserList(UserInfo userInfo);

    /**
     * 删除信息
     * @param id
     * @return
     */
    int deleteUserInfo(Integer id);

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    List<UserInfo> selectInfoByName(String name);

    /**
     * 根据地址查询
     * @param address
     * @return
     */
    List<UserInfo> selectInfoByAddress(String address);

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    List selectPage(Integer page, Integer size);

    /**
     * 添加信息
     * @param userInfo
     */
    void addUserInfo(UserInfo userInfo);


}
