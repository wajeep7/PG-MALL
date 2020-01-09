package com.pg.mall.user.mapper;

import com.pg.mall.user.bean.UmsMember;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: 用户dao层
 * @author: pg_7
 * @create: 2020-01-09 17:01
 **/
public interface UmsMemberMapper {

    List<UmsMember> selectUserAll();
}
