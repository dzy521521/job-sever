package com.example.demo.service;

import com.example.demo.dao.CityDao;
import com.example.demo.dao.ResumeDao;
import com.example.demo.entity.City;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.util.response.CodeMsg;
import com.example.demo.util.response.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("resumeService")
public class ResumeService {
    @Resource
    private ResumeDao resumeDao;

    public Result getResume(User user) {
        Resume resume = resumeDao.getResume(user);
        if(resume == null){
            return Result.fail(CodeMsg.ERROR("尚未填写简历"));
        }
        return Result.success(resume);
    }

    public Result updateResume(Resume resume) {
       int result = resumeDao.updateResume(resume);
        if(result == 1){
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("简历更新失败"));
    }

    public Result insertResume(Resume resume) {
        int result = resumeDao.insertResume(resume);
        if(result == 1){
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("创建简历失败"));
    }


}
