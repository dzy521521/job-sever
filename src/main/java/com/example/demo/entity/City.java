package com.example.demo.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(description="城市对象City")
public class City {
    private Integer id;

    private String name;

    private String code;

    private String precode;

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
}
