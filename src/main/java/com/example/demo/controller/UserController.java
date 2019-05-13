package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(value = "用户controller", description = "用户操作", tags = {"用户操作接口"})
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("用户登陆 - 账号密码")
    @PostMapping(value = "/login")
    @ResponseBody
    public Result<User> Login(@RequestBody User user) {
        return userService.login(user);
    }

    @ApiOperation("用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public Result<User> Register(@RequestBody User user) {
        return userService.register(user);
    }

    @ApiOperation("修改密码")
    @PostMapping(value = "/changePwd")
    @ResponseBody
    public Result<User> ChangePwd(@RequestBody User user) {
        return userService.changePwd(user);
    }

    @ApiOperation("修改招聘应聘状态")
    @PostMapping(value = "/changeFlag")
    @ResponseBody
    public Result<User> changeFlag(@RequestBody User user) {
        return userService.changeFlag(user);
    }

    @ApiOperation("修改个人信息")
    @PostMapping(value = "/changeInfo")
    @ResponseBody
    public Result<User> changeInfo(@RequestBody User user) {
        return userService.changeInfo(user);
    }

}