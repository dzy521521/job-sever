package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    /*int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/


    /* 根据手机号 + 角色获取用户*/
    User selectByPhoneAndRole(User record);
    /* 插入用户 */
    int insertUser(User record);
    /* 修改密码 */
    int updateUserPwd(User record);
    /* 修改状态 */
    int updateUserFlag(User record);

    /* 修改昵称和个人简介 */
    int updateUserInfo(User record);
}
