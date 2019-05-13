package com.example.demo.service;

import com.example.demo.dao.CompanyDao;
import com.example.demo.dao.IntentDao;
import com.example.demo.entity.Company;
import com.example.demo.entity.Intent;
import com.example.demo.entity.User;
import com.example.demo.util.response.CodeMsg;
import com.example.demo.util.response.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("intentService")
public class IntentService {
    @Resource
    private IntentDao intentDao;

    public Result getIntentsByUser(User user) {
        List<Intent> intents = intentDao.getIntentsByUser(user);
        if(intents.size() == 0){
            return Result.fail(CodeMsg.ERROR("尚未填写意向"));
        }
        return Result.success(intents);
    }

    public Result deleteIntent(Intent intent) {
       int result = intentDao.deleteIntent(intent);
        if(result == 1){
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("删除意向失败"));
    }

    public Result insertIntent(Intent intent) {
        int result = intentDao.insertIntent(intent);
        if(result == 1){
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("创建意向失败"));
    }
    public Result updateIntent(Intent intent) {
        int result = intentDao.updateIntent(intent);
        if(result == 1){
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("更新意向失败"));
    }

}
