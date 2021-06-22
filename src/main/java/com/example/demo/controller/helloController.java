package com.example.demo.controller;


import cn.hutool.crypto.SecureUtil;
import com.example.demo.api.CommonResult;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class helloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (userService.getUserName(username).equals(user.getUsername()) && userService.getPassWord(password).equals(user.getPassword())
                && user.getUsername().equals("cityManager")){
            return CommonResult.success("系统管理员");
        }

        else if (userService.getUserName(username).equals(user.getUsername()) && userService.getPassWord(password).equals(user.getPassword())
                && user.getUsername().equals("xiongziqi")){
            return CommonResult.success("子祈哥哥");
        }

        else if (userService.getUserName(username).equals(user.getUsername()) && userService.getPassWord(password).equals(user.getPassword())
                && user.getUsername().equals("chenshaofen")){
            return CommonResult.success("绍芬妹妹");
        }
        else if (userService.getUserName(username).equals(user.getUsername()) && userService.getPassWord(password).equals(user.getPassword())){
            return CommonResult.success(username);
        }

        else {
            return CommonResult.validateFailed();
        }

    }

    @RequestMapping(value = "/admin/register",method = RequestMethod.POST)
    public String register(String username,String password){
        //使用Hutool中的SecureUtil对密码进行加密
        String mdPassWord = SecureUtil.md5(password);
        userService.userRegister(username,mdPassWord);
        return null;
    }
}
