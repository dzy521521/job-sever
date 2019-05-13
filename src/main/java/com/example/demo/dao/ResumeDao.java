package com.example.demo.dao;

import com.example.demo.entity.Job;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeDao {

    /* 获取简历 */
   Resume getResume(User user);

   /* 修改简历 */
    int updateResume(Resume resume);

   /* 保存简历 */
   int insertResume(Resume resume);
}
