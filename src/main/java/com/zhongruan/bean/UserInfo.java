package com.zhongruan.bean;

import lombok.Data;

/***********************************************
 #
 #     @Classname UserInfo
 #     @Description TODO
 #     @Date 2019/7/15 9:24
 #     Created by weihuan 1548710086@qq.com
 #     
 ***********************************************/
@Data
public class UserInfo {
    int id;
    private String username;
    private String password;

    public UserInfo() {

    }

    public UserInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
