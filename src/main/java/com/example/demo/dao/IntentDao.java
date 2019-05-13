package com.example.demo.dao;

import com.example.demo.entity.Company;
import com.example.demo.entity.Intent;
import com.example.demo.entity.User;
import com.example.demo.entity.temp.RelationTemp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IntentDao {

    /* 获取意向 */
   List<Intent> getIntentsByUser(User user);

    /* 获取意向 */
    Intent getIntentsById(Integer id);

   /* 删除意向 */
    int deleteIntent(Intent intent);

    /* 更新意向 */
    int updateIntent(Intent intent);

   /* 添加意向 */
   int insertIntent(Intent intent);

    /* 查询意向 */
    List<Intent> selectIntent(RelationTemp relationTemp);
}
