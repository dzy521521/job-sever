package com.example.demo.dao;

import com.example.demo.entity.Relation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RelationDao {

    /* 获取dashboard数值 */
    Integer getRelationAmount(Relation relation);

    /* 获取关系  Relation （employee / employer 、 type） */
    List<Relation> getRelationByTypeAndRole(Relation relation);

    /* 定向查询 */
    Relation getRelationByIntentId(Relation relation);

    /* 定向查询 */
    Relation getRelationById(Integer id);

    /* 插入关系 */
    int insertRelation(Relation relation);

    /* 修改关系 - 面试 */
    int updateRelation(Relation relation);
}
