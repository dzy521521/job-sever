package com.example.demo.dao;

import com.example.demo.entity.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobDao {

    /* 获取所有Job */
   List<Job> getJobAll();
}
