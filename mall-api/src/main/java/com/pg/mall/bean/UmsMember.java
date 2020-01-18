package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
/**
 *
 *
 * @Description: 用户表 
 * @Param:
 * @return:  
 * @Author: pg-7 
 * @Date: 2020/1/12 
 */ 
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UmsMember implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String memberLevelId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int status;
    private Date createTime;
    private String icon;
    private int gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private int sourceType;
    private int integration;
    private int growth;
    private int luckeyCount;
    private int historyIntegration;
}
