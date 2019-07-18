package com.zhongruan.controller;

import com.github.pagehelper.PageInfo;
import com.zhongruan.bean.UserInfo;
import com.zhongruan.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/***********************************************
 #
 #     @Classname UserInfoController
 #     @Description TODO
 #     @Date 2019/7/15 9:50
 #     Created by weihuan 1548710086@qq.com
 #     
 ***********************************************/
@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

//    @RequestMapping("/allUser.do")
//    public ModelAndView findAll() {
//        ModelAndView mv = new ModelAndView();
//        List<UserInfo> userInfos = userInfoService.findALl();
//        mv.addObject("userInfos", userInfos);
//        mv.setViewName("user-list");
//        return mv;
//    }

    @RequestMapping("/allUser.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userInfoService.findALl(page, size);
        PageInfo pageInfo = new PageInfo(userInfos);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * @RequestMapping("/login.do") public ModelAndView login(UserInfo userInfo ) {
     * ModelAndView mv = new ModelAndView();
     * if(null == userInfo.getUsername()){
     * mv.setViewName("../index");
     * }else{
     * boolean flag = userInfoService.login(userInfo);
     * if (flag == true) {
     * mv.setViewName("main");
     * }else{
     * mv.setViewName("../failer");
     * }
     * }
     * <p>
     * //        mv.addObject("userInfos", userInfos);
     * <p>
     * return mv;
     * }
     */

    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo) {
        userInfoService.addUserInfo(userInfo);
        return "redirect:allUser.do";
    }

    @RequestMapping("/toUpdate.do")
    public ModelAndView toUpdate(int id) {
//        System.out.println("11111111111111111111111111111");
        UserInfo userInfo = userInfoService.selectById(id);
//        System.out.println(userInfo.getUsername());
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userInfo);
        mv.setViewName("user-update");
        return mv;
    }

    @RequestMapping("/update.do")
    public String update(UserInfo userInfo) {
        userInfoService.update(userInfo);
//        mv.addObject("userInfo",userInfo);
        return "redirect:/user/allUser.do";
    }

    @RequestMapping("deleteUser.do")
    public String deleteUserInfo(int id) {
        userInfoService.deleteUserInfo(id);
        return "redirect:allUser.do";
    }

    @RequestMapping("/deleteAll.do")
    @ResponseBody
    public String deleteAll(String userList) {
//        System.out.println("11111111111");
        String[] strs = userList.split(",");
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            //将string类型转化危 int
            ids.add(Integer.parseInt(strs[i]));
        }
        userInfoService.deleteAll(ids);
        return "";
    }
}
