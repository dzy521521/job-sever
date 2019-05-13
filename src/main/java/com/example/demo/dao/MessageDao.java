package com.example.demo.dao;

import com.example.demo.entity.City;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDao {

    /* 获取消息 */
    List<Message> getMessage(User user);

    /* 插入消息 */
    int insertMessage(Message message);
}
