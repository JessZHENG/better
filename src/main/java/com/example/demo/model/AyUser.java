package com.example.demo.model;
/**
 * 描述：用户表
 * @Author 阿毅
 * @date   2017/10/8.
 */
public class AyUser {

    //主键
    private String id;
    //用户名
    private String name;
    //密码
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
