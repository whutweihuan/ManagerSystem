package com.zhongruan.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhongruan.bean.Role;
import com.zhongruan.bean.UserInfo;
import com.zhongruan.dao.IRoleDao;
import com.zhongruan.dao.IUserInfoDao;
import com.zhongruan.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/***********************************************
 #
 #     @Classname UserInfoService
 #     @Description TODO
 #     @Date 2019/7/15 9:47
 #     Created by weihuan 1548710086@qq.com
 #     
 ***********************************************/
@Service("userInfoService")
public class UserInfoService implements IUserInfoService {
    @Autowired
    IUserInfoDao userInfoDao;

    @Autowired
    IRoleDao roleDao;

//    @Override
//    public List<UserInfo> findALl() {
//        return userInfoDao.findAll();
//    }

    @Override
    public List<UserInfo> findALl(int page, int size) {
        PageHelper.startPage(page, size);
        return userInfoDao.findAll();
    }

    @Override
    public boolean login(UserInfo userInfo) {
        UserInfo userinfo = userInfoDao.login(userInfo);
        if (userinfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public UserInfo selectById(int id) {
        return userInfoDao.selectById(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoDao.updateUserinfo(userInfo);
    }

    @Override
    public void deleteUserInfo(int id) {
        userInfoDao.deleteUserInfo(id);
    }

    @Override
    public void deleteAll(List<Integer> ids) {
        userInfoDao.deleteAll(ids);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findByUserName(username);
        List<Role> roles = roleDao.findRoleByUserId(userInfo.getId());
        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), getAuthority(roles));

        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
        }
        return list;
    }


}













