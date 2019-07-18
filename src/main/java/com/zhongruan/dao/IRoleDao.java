package com.zhongruan.dao;

import com.zhongruan.bean.Role;

import java.util.List;

/***********************************************
 #
 #     @Classname IRoleDao
 #     @Description TODO
 #     @Date 2019/7/17 10:19
 #     Created by weihuan 1548710086@qq.com
 #     
 ***********************************************/
public interface IRoleDao {
    List<Role> findRoleByUserId(int id);
}
