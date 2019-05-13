package com.example.demo.service;

import com.example.demo.dao.CityDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.City;
import com.example.demo.entity.User;
import com.example.demo.util.response.CodeMsg;
import com.example.demo.util.response.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("cityService")
public class CityService {
    @Resource
    private CityDao cityDao;

    public Result getAllCity() {
        List<City> citys = cityDao.getCityAll();
        return Result.success(citys);
    }


}
