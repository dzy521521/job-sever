package com.example.demo.dao;

import com.example.demo.entity.City;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityDao {

    /* 获取所有城市 */
   List<City> getCityAll();
}
