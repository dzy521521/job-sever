package com.example.demo.controller;

import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.service.CityService;
import com.example.demo.service.ResumeService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "简历controller", description = "", tags = {"简历操作接口"})
@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @ApiOperation("获取简历")
    @PostMapping(value = "/getResume")
    @ResponseBody
    public Result<Resume> getResume(@RequestBody User user) {
        return resumeService.getResume(user);
    }

    @ApiOperation("更新简历")
    @PostMapping(value = "/updateResume")
    @ResponseBody
    public Result<Resume> updateResume(@RequestBody Resume resume) {
        return resumeService.updateResume(resume);
    }

    @ApiOperation("新建简历")
    @PostMapping(value = "/insertResume")
    @ResponseBody
    public Result<Resume> insertResume(@RequestBody Resume resume) {
        return resumeService.insertResume(resume);
    }
}