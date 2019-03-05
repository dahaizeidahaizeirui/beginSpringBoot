package com.edityj.chapter2.pojo;

import com.edityj.chapter2.EnumType.SexEnum;
import org.apache.ibatis.type.Alias;

@Alias("role")
public class Role {
    private Long id = null;
    private String username = null;
    private String password = null;
    private SexEnum sex = null;
    private String name = null;

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
