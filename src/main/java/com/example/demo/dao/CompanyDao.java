package com.example.demo.dao;

import com.example.demo.entity.Company;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDao {

    /* 获取公司 */
   Company getCompany(User user);

   /* 修改公司 */
    int updateCompany(Company company);

   /* 保存公司 */
   int insertCompany(Company company);
}
