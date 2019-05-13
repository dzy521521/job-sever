package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.service.CityService;
import com.example.demo.service.JobService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Api(value = "岗位controller", description = "", tags = {"岗位操作接口"})
@Controller
@RequestMapping("/job")
public class JobController {
    @Resource
    private JobService jobService;

    @ApiOperation("获取所有岗位")
    @GetMapping(value = "/jobs")
    @ResponseBody
    public Result<Job> getAllJob() {
        return jobService.getAllJob();
    }


}