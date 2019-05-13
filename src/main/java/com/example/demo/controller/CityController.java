package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.User;
import com.example.demo.service.CityService;
import com.example.demo.service.UserService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "城市controller", description = "", tags = {"城市操作接口"})
@Controller
@RequestMapping("/city")
public class CityController {
    @Resource
    private CityService cityService;

    @ApiOperation("获取所有城市")
    @GetMapping(value = "/citys")
    @ResponseBody
    public Result<City> getAllCity() {
        return cityService.getAllCity();
    }


}