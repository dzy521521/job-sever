package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.User;
import com.example.demo.service.CityService;
import com.example.demo.service.MessageService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Api(value = "消息controller", description = "", tags = {"消息操作接口"})
@Controller
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @ApiOperation("获取消息")
    @PostMapping(value = "/getMessage")
    @ResponseBody
    public Result<City> getMessage(@RequestBody User user) {
        return messageService.getMessage(user);
    }


}