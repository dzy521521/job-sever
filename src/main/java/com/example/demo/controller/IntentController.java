package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.Intent;
import com.example.demo.entity.User;
import com.example.demo.service.CityService;
import com.example.demo.service.IntentService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "意向controller", description = "", tags = {"意向操作接口"})
@Controller
@RequestMapping("/intent")
public class IntentController {
    @Resource
    private IntentService intentService;

    @ApiOperation("获取意向")
    @PostMapping(value = "/getIntentsByUser")
    @ResponseBody
    public Result<Intent> getIntentsByUser(@RequestBody User user) {
        return intentService.getIntentsByUser(user);
    }

    @ApiOperation("删除意向")
    @PostMapping(value = "/deleteIntent")
    @ResponseBody
    public Result<Intent> deleteIntent(@RequestBody Intent intent) {
        return intentService.deleteIntent(intent);
    }

    @ApiOperation("获取意向")
    @PostMapping(value = "/insertIntent")
    @ResponseBody
    public Result<Intent> insertIntent(@RequestBody Intent intent) {
        return intentService.insertIntent(intent);
    }

    @ApiOperation("更新意向")
    @PostMapping(value = "/updateIntent")
    @ResponseBody
    public Result<Intent> updateIntent(@RequestBody Intent intent) {
        return intentService.updateIntent(intent);
    }

}