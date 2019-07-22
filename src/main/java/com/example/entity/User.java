package com.example.entity;

import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private long id;

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 2,max = 20)
    @Column(nullable = false,length = 20)
    private String userName;

    @NotEmpty(message = "邮箱不能为空")
    @Size(max=50)
    @Email(message = "邮箱格式不对")
    private String email;

    @NotEmpty(message = "密码不能为空")
    @Size(max =100)
    @Column(length = 100)
    private String password;

    @Column(length = 200)
    private String avatar;

    protected User(){}
    public User(String userName,String email,String password){
        this.userName=userName;
        this.email=email;
        this.password=password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString(){
        return String.format(
                "User[id=%d,userName='%s',email='%s']",id,userName,email);
    }
}
