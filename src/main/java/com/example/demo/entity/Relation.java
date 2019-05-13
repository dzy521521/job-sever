package com.example.demo.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(description="关系对象Relation")
public class Relation {
    private Integer id;

    private Integer employeeIntentId;

    private Integer employerIntentId;

    private String createTime;

    private String interviewTime;

    private String type;

    private String employee;

    private String employer;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeIntentId() {
        return employeeIntentId;
    }

    public void setEmployeeIntentId(Integer employeeIntentId) {
        this.employeeIntentId = employeeIntentId;
    }

    public Integer getEmployerIntentId() {
        return employerIntentId;
    }

    public void setEmployerIntentId(Integer employerIntentId) {
        this.employerIntentId = employerIntentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
}
