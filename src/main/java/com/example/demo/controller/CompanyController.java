package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.service.CompanyService;
import com.example.demo.service.ResumeService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Api(value = "企业controller", description = "", tags = {"企业操作接口"})
@Controller
@RequestMapping("/company")
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @ApiOperation("获取企业")
    @PostMapping(value = "/getCompany")
    @ResponseBody
    public Result<Company> getCompany(@RequestBody User user) {
        return companyService.getCompany(user);
    }

    @ApiOperation("更新企业")
    @PostMapping(value = "/updateCompany")
    @ResponseBody
    public Result<Company> updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @ApiOperation("新建企业")
    @PostMapping(value = "/insertCompany")
    @ResponseBody
    public Result<Company> insertCompany(@RequestBody Company company) {
        return companyService.insertCompany(company);
    }
}