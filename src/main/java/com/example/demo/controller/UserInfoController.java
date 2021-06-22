package com.example.demo.controller;

import com.example.demo.api.CommonResult;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value = "/userInfo/select")
    public CommonResult selectUserList(UserInfo userInfo){
        List data = userInfoService.selectUserList(userInfo);
        return CommonResult.success(data);
    }

    @ResponseBody
    @RequestMapping(value = "/userInfo/delete")
    public CommonResult deleteUserInfo(Integer id){
        int deleteId = userInfoService.deleteUserInfo(id);
        return CommonResult.success(deleteId);
    }

    @RequestMapping(value = "/userInfo/selectByName")
    public CommonResult selectInfoByName(String name){
        List data = userInfoService.selectInfoByName(name);
        return CommonResult.success(data);
    }

    @RequestMapping(value = "/userInfo/selectByAddress")
    public CommonResult selectInfoByAddress(String address){
        List data = userInfoService.selectInfoByAddress(address);
        return CommonResult.success(data);
    }

//    @RequestMapping(value = "/userInfo/selectPage",method = RequestMethod.GET)
//    public RespPageBean selectPage(@RequestParam(defaultValue = "1") Integer page,
//                                   @RequestParam(defaultValue = "10") Integer size){
//        PageHelper.startPage(page,size);
//        return userInfoService.selectPage(page, size);
//    }

    @RequestMapping(value = "/userInfo/selectPage",method = RequestMethod.GET)
    public Object selectPage(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer size){
        return userInfoService.selectPage(page,size);
    }

    @RequestMapping(value = "/userInfo/addUser")
    public void addUserInfo(UserInfo userInfo){
        userInfoService.addUserInfo(userInfo);
    }
}
