package com.pg.mall.user.controller;

import com.pg.mall.user.bean.UmsMember;
import com.pg.mall.user.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: 用户首页跳转
 * @author: pg_7
 * @create: 2020-01-09 16:54
 **/
@Controller
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){

        return umsMemberService.getAllUser();
    }

    /**
     *
     *
     * @Description: 首页测试
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: pg-7 
     * @Date: 2020/1/9 
     */ 
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "进入首页";
    }
}
