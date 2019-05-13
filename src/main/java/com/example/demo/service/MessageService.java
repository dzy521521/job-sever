package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.CityDao;
import com.example.demo.dao.MessageDao;
import com.example.demo.dao.RelationDao;
import com.example.demo.entity.City;
import com.example.demo.entity.Message;
import com.example.demo.entity.Relation;
import com.example.demo.entity.User;
import com.example.demo.util.JiguangPush;
import com.example.demo.util.response.CodeMsg;
import com.example.demo.util.response.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("messageService")
public class MessageService {
    @Resource
    private MessageDao messageDao;

    @Resource
    private RelationDao relationDao;

    @Resource
    private RelationService relationService;

    public Result getMessage(User user) {
        List<Message> messages = messageDao.getMessage(user);
        if (messages == null || messages.size() == 0) {
            return Result.fail(CodeMsg.ERROR("暂无数据"));
        }
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < messages.size(); i++) {
            Relation relation = relationDao.getRelationById(messages.get(i).getRelationId());
            JSONObject jsonObject = relationService.getRelationByIntentId(relation);
            jsonObject.put("message", messages.get(i));
            jsonArray.add(jsonObject);
        }
        return Result.success(jsonArray);
    }

}
