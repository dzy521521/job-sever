package com.example.demo.service;

import com.example.demo.dao.CityDao;
import com.example.demo.dao.JobDao;
import com.example.demo.entity.City;
import com.example.demo.entity.Job;
import com.example.demo.util.response.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("jobService")
public class JobService {
    @Resource
    private JobDao jobDao;

    public Result getAllJob() {
        List<Job> jobs = jobDao.getJobAll();
        return Result.success(jobs);
    }


}
