package com.zhongruan.bean;

/***********************************************
 #
 #     @Classname Role
 #     @Description TODO
 #     @Date 2019/7/17 10:12
 #     Created by weihuan 1548710086@qq.com
 #     
 ***********************************************/
public class Role {
    private int id;
    private String rolename;
    private String roleDesc;

    public int getId() {
        return id;
    }

    public String getRolename() {
        return rolename;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
