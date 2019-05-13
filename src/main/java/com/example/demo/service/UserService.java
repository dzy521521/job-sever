package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.util.response.CodeMsg;
import com.example.demo.util.response.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserService {
    @Resource
    private UserDao userDao;

    public Result login(User user) {
        User user_ = userDao.selectByPhoneAndRole(user);
        if(user_ == null){
            return Result.fail(CodeMsg.ERROR("手机号尚未注册"));
        } else if (!user_.getPwd().equals(user.getPwd())){
            return Result.fail(CodeMsg.ERROR("密码错误"));
        } else {
            return Result.success(user_);
        }
    }

    public Result register(User user) {
        User user_ = userDao.selectByPhoneAndRole(user);
        if(user_ != null){
            return Result.fail("用户已经存在");
        }
        int result = userDao.insertUser(user);
        if(result == 1){
            return Result.success(userDao.selectByPhoneAndRole(user));
        } else {
            return Result.fail("注册失败");
        }
    }

    public Result changePwd(User user) {
        int result = userDao.updateUserPwd(user);
        if(result == 1){
            return Result.success();
        } else {
            return Result.fail("修改密码失败");
        }
    }

    public Result changeFlag(User user) {
        int result = userDao.updateUserFlag(user);
        if(result == 1){
            return Result.success();
        } else {
            return Result.fail("修改状态失败");
        }
    }

    public Result changeInfo(User user) {
        int result = userDao.updateUserInfo(user);
        if(result == 1){
            return Result.success();
        } else {
            return Result.fail("修改个人信息失败");
        }
    }

}
