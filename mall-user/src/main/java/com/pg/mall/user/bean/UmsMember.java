package com.pg.mall.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @program: PG-MALL
 * @description: //会员表
 * @author: pg_7
 * @create: 2020-01-09 17:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UmsMember {
    private Integer Id;
    private Integer Member_Level_Id;
    private String UserName; //用户名
    private String PassWord; //密码
    private String Nickname; //昵称
    private String Phone;    //手机号码
    private Integer Status;  //帐号启用状态:0->禁用；1->启用
    private Date Create_Time; //注册时间
    private String Icon;     //头像
    private Integer Gender;  //性别：0->未知；1->男；2->女
    private Date Birthday;   //生日
    private String City;     //所做城市
    private String Job;      //职业
    private String PersonalIZed_Signature;//个性签名
    private Integer Source_Type;//用户来源
    private Integer InTegRation; //积分
    private Integer Growth; //成长值
    private Integer Luckey_Count;//剩余抽奖次数
    private Integer History_InTegRation;//历史积分数量

}
