package com.example.demo.service;

import com.example.demo.dao.CompanyDao;
import com.example.demo.dao.ResumeDao;
import com.example.demo.entity.Company;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.util.response.CodeMsg;
import com.example.demo.util.response.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("companyService")
public class CompanyService {
    @Resource
    private CompanyDao companyDao;

    public Result getCompany(User user) {
        Company company = companyDao.getCompany(user);
        if(company == null){
            return Result.fail(CodeMsg.ERROR("企业信息填写简历"));
        }
        return Result.success(company);
    }

    public Result updateCompany(Company company) {
       int result = companyDao.updateCompany(company);
        if(result == 1){
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("企业信息更新失败"));
    }

    public Result insertCompany(Company company) {
        int result = companyDao.insertCompany(company);
        if(result == 1){
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("创建企业信息失败"));
    }


}
