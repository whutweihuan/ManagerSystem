package com.zhongruan.service;

import com.zhongruan.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/***********************************************
 #
 #     @Classname IUserInfoService
 #     @Description TODO
 #     @Date 2019/7/15 9:48
 #     Created by weihuan 1548710086@qq.com
 #     
 ***********************************************/
public interface IUserInfoService extends UserDetailsService {
//    List<UserInfo> findALl();

    List<UserInfo> findALl(int page, int size);

    public boolean login(UserInfo userInfo);

    public void addUserInfo(UserInfo userInfo);

    public UserInfo selectById(int id);

    public void update(UserInfo userInfo);

    public void deleteUserInfo(int id);

    public void deleteAll(List<Integer> ids);
}
