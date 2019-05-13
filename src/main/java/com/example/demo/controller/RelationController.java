package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.Relation;
import com.example.demo.entity.User;
import com.example.demo.entity.temp.RelationTemp;
import com.example.demo.service.CityService;
import com.example.demo.service.RelationService;
import com.example.demo.util.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "关系controller", description = "", tags = {"关系操作接口"})
@Controller
@RequestMapping("/relation")
public class RelationController {
    @Resource
    private RelationService relationService;

    @ApiOperation("条件查询")
    @PostMapping(value = "/selectRelation")
    @ResponseBody
    public Result<City> selectRelation(@RequestBody RelationTemp relationTemp) {
        return relationService.selectRelation(relationTemp);
    }

    @ApiOperation("获取关系数量")
    @PostMapping(value = "/amounts")
    @ResponseBody
    public Result<City> getRelationAmount(@RequestBody Relation relation) {
        return relationService.getRelationAmount(relation);
    }

    @ApiOperation("获取关系 List<Relation>  （employee / employer 、 type）")
    @PostMapping(value = "/getRelationByTypeAndRole")
    @ResponseBody
    public Result<City> getRelationByTypeAndRole(@RequestBody Relation relation) {
        return relationService.getRelationByTypeAndRole(relation);
    }

  /*  @ApiOperation("获取关系 Relation  （employee 、 employer 、 employerIntentId）")
    @PostMapping(value = "/getRelationByIntentId")
    @ResponseBody
    public Result<City> getRelationByIntentId(@RequestBody Relation relation) {
        return relationService.getRelationByIntentId(relation);
    }*/

    @ApiOperation("修改关系 - 面试")
    @PostMapping(value = "/updateRelation")
    @ResponseBody
    public Result<City> updateRelation(@RequestBody Relation relation) {
        return relationService.updateRelation(relation);
    }

    @ApiOperation("插入关系")
    @PostMapping(value = "/insertRelation")
    @ResponseBody
    public Result<City> insertRelation(@RequestBody Relation relation) {
        return relationService.insertRelation(relation);
    }
}