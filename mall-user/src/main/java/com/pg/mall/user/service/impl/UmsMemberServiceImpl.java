package com.pg.mall.user.service.impl;

import com.pg.mall.user.bean.UmsMember;
import com.pg.mall.user.mapper.UmsMemberMapper;
import com.pg.mall.user.service.UmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: 用户实现类
 * @author: pg_7
 * @create: 2020-01-09 16:56
 **/
@Service
@Slf4j
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper umsMemberMapper;


    @Override
    public List<UmsMember> getAllUser() {
        return umsMemberMapper.selectUserAll();

    }
}
