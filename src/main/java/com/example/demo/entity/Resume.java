package com.example.demo.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(description="简历对象Resume")
public class Resume {
    private Integer id;

    private String phone;

    private String photo;

    private String name;

    private String sex;

    private String birthTime;

    private String workTime;

    private String education;

    private String educationExp;

    private String workExp;

    private String projectExp;

    private String good;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducationExp() {
        return educationExp;
    }

    public void setEducationExp(String educationExp) {
        this.educationExp = educationExp;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getProjectExp() {
        return projectExp;
    }

    public void setProjectExp(String projectExp) {
        this.projectExp = projectExp;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }
}
