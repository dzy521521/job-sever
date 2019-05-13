package com.example.demo.entity;
import io.swagger.annotations.ApiModel;

@ApiModel(description="岗位对象Job")
public class Job {
    private Integer id;

    private String name;

    private String code;

    private String precode;

    private String des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrecode() {
        return precode;
    }

    public void setPrecode(String precode) {
        this.precode = precode;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
