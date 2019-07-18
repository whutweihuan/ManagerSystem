package com.zhongruan.dao;


import com.zhongruan.bean.UserInfo;

import javax.xml.registry.infomodel.User;
import java.util.List;

/***********************************************
 #
 #     @Classname IUserInfoDao
 #     @Description TODO
 #     @Date 2019/7/15 9:28
 #     Created by weihuan 1548710086@qq.com
 #     
 ***********************************************/
public interface IUserInfoDao {
    public List<UserInfo> findAll();

    public UserInfo login(UserInfo userInfo);

    public void addUserInfo(UserInfo userInfo);

    public UserInfo selectById(int id);

    public void updateUserinfo(UserInfo userInfo);

    public void deleteUserInfo(int id);

    public UserInfo findByUserName(String username);

    public void deleteAll(List<Integer> ids);
//    public void deleteAll(List<Integer> ids);
}
