package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.entity.temp.RelationTemp;
import com.example.demo.util.JiguangPush;
import com.example.demo.util.response.CodeMsg;
import com.example.demo.util.response.Result;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("relationService")
public class RelationService {
    @Resource
    private RelationDao relationDao;

    @Resource
    private CompanyDao companyDao;

    @Resource
    private IntentDao intentDao;

    @Resource
    private ResumeDao resumeDao;

    @Resource
    private UserDao userDao;

    @Resource
    private MessageDao messageDao;

    public Result selectRelation(RelationTemp relationTemp) {
        List<Intent> intents = intentDao.selectIntent(relationTemp);
        if(intents == null || intents.size() == 0) {
            return Result.fail(CodeMsg.ERROR("暂无数据"));
        }

        User user = new User();
        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i < intents.size() ; i++) {
            JSONObject jsonObject = new JSONObject();
            Relation relation = new Relation();
            if (relationTemp.getRole().equals("employee")) {
                // 企业查员工
                user.setRole("employee");
                user.setPhone(intents.get(i).getPhone());
                jsonObject.put("employee", userDao.selectByPhoneAndRole(user));
                jsonObject.put("resume",resumeDao.getResume(user));
                user.setRole("employer");
                user.setPhone(relationTemp.getEmployer());
                jsonObject.put("employer", userDao.selectByPhoneAndRole(user));
                jsonObject.put("company",companyDao.getCompany(user));
                relation.setEmployer(relationTemp.getEmployer());
                relation.setEmployee(intents.get(i).getPhone());
                relation.setEmployerIntentId(relationTemp.getEmployerIntentId());
            } else {
                // 员工查企业
                user.setRole("employee");
                user.setPhone(relationTemp.getEmployee());
                jsonObject.put("employee", userDao.selectByPhoneAndRole(user));
                jsonObject.put("resume",resumeDao.getResume(user));
                user.setRole("employer");
                user.setPhone(intents.get(i).getPhone());
                jsonObject.put("employer", userDao.selectByPhoneAndRole(user));
                jsonObject.put("company",companyDao.getCompany(user));
                relation.setEmployer(intents.get(i).getPhone());
                relation.setEmployee(relationTemp.getEmployee());
                relation.setEmployerIntentId(intents.get(i).getId());
            }
            Relation relation1 = relationDao.getRelationByIntentId(relation);
            if (relation1 == null) {
                relation.setType("-1");
                jsonObject.put("relation", relation);
            } else {
                jsonObject.put("relation", relation1);
            }
            jsonObject.put("intent", intents.get(i));
            jsonArray.add(jsonObject);
        }
        return Result.success(jsonArray);
    }
    public Result getRelationAmount(Relation relation) {
        ArrayList<Integer> list = new ArrayList<>();
        relation.setType("0");
        list.add(relationDao.getRelationAmount(relation));
        relation.setType("1");
        list.add(relationDao.getRelationAmount(relation));
        relation.setType("2");
        list.add(relationDao.getRelationAmount(relation));
        return Result.success(list);
    }

    public Result getRelationByTypeAndRole(Relation relation) {
        List<Relation> relations = relationDao.getRelationByTypeAndRole(relation);
        if(relations == null) {
            return Result.fail(CodeMsg.ERROR("暂无数据"));
        }
        JSONArray jsonArray = new JSONArray();
        Intent intent;
        Company company;
        Resume resume;
        User user_employer,user_employee;
        User user = new User();
        for(int i = 0; i < relations.size(); i++) {
            intent = intentDao.getIntentsById(relations.get(i).getEmployerIntentId());
            user.setPhone(relations.get(i).getEmployer());
            user.setRole("employer");
            user_employer = userDao.selectByPhoneAndRole(user);
            company = companyDao.getCompany(user);
            user.setPhone(relations.get(i).getEmployee());
            user.setRole("employee");
            user_employee = userDao.selectByPhoneAndRole(user);
            resume = resumeDao.getResume(user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("relation", relations.get(i));
            jsonObject.put("intent", intent);
            jsonObject.put("company", company);
            jsonObject.put("resume", resume);
            jsonObject.put("employer", user_employer);
            jsonObject.put("employee", user_employee);
            jsonArray.add(jsonObject);
        }
        return Result.success(jsonArray);
    }

    public JSONObject getRelationByIntentId(Relation relation) {
        Relation relation_ = relationDao.getRelationByIntentId(relation);
        if(relation_ == null) {
            return null;
        }
        User user = new User();
        Intent intent = intentDao.getIntentsById(relation_.getEmployerIntentId());
        user.setPhone(relation_.getEmployer());
        user.setRole("employer");
        User user_employer = userDao.selectByPhoneAndRole(user);
        Company company = companyDao.getCompany(user);
        user.setPhone(relation_.getEmployee());
        user.setRole("employee");
        User user_employee = userDao.selectByPhoneAndRole(user);
        Resume resume = resumeDao.getResume(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("relation", relation_);
        jsonObject.put("intent", intent);
        jsonObject.put("company", company);
        jsonObject.put("resume", resume);
        jsonObject.put("employer", user_employer);
        jsonObject.put("employee", user_employee);
        return jsonObject;
    }

    public Result insertRelation(Relation relation) {
        int result = relationDao.insertRelation(relation);
        if(result == 1){
            Relation relation1 = relationDao.getRelationByIntentId(relation);
            Message message = new Message();
            message.setRelationId(relation1.getId());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
            if(relation.getType().equals("0")) {
                // 投递简历
                new JiguangPush().jiguangPush(relation.getEmployer() + "employer", "收到新的简历");
                message.setPhone(relation1.getEmployer());
                message.setRole("employer");
                message.setContent("收到新的简历");
                message.setTitle("简历投递");
                message.setCreateTime(df.format(new Date()));
                messageDao.insertMessage(message);
            }
            if(relation.getType().equals("1")) {
                // 面试邀约
                new JiguangPush().jiguangPush(relation.getEmployee() + "employee", "收到企业面试邀请");
                message.setPhone(relation1.getEmployee());
                message.setRole("employee");
                message.setContent("收到企业面试邀请");
                message.setTitle("面试邀请");
                message.setCreateTime(df.format(new Date()));
                messageDao.insertMessage(message);
            }
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("招聘关系创建失败"));
    }

    public Result updateRelation(Relation relation) {
        Relation relation1 = relationDao.getRelationById(relation.getId());
        int result = relationDao.updateRelation(relation);
        if(result == 1){
            Message message = new Message();
            message.setRelationId(relation1.getId());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式

            if(relation1.getType().equals("0")) {
                // 同意简历
                new JiguangPush().jiguangPush(relation1.getEmployee() + "employee", "您投递的简历已通过审核");
                message.setPhone(relation1.getEmployee());
                message.setRole("employee");
                message.setContent("您投递的简历已通过审核");
                message.setTitle("简历投递");
                message.setCreateTime(df.format(new Date()));
                messageDao.insertMessage(message);
            }
            if(relation1.getType().equals("1")) {
                // 接受面试
                new JiguangPush().jiguangPush(relation1.getEmployer() + "employer", "您的面试邀请已被接受");
                message.setPhone(relation1.getEmployer());
                message.setRole("employer");
                message.setContent("您的面试邀请已被接受");
                message.setTitle("面试邀请");
                message.setCreateTime(df.format(new Date()));
                messageDao.insertMessage(message);
            }
            return Result.success();
        }
        return Result.fail(CodeMsg.ERROR("招聘关系更新失败"));
    }
}
