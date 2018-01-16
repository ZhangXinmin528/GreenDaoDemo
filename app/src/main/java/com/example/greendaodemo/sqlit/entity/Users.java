package com.example.greendaodemo.sqlit.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/15.
 * Copyright (c) 2018 . All rights reserved.
 */
@Entity
public class Users {
    @Id
    @Unique
    private Long id;

    @NotNull
    private String name;

    private String sex;

    private String address;

    private String desc;

    @Generated(hash = 1066089276)
    public Users(Long id, @NotNull String name, String sex, String address,
            String desc) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.desc = desc;
    }

    @Generated(hash = 2146996206)
    public Users() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
