package com.pg.mall.user.mapper;


import com.pg.mall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<UmsMember> {

    UmsMember selectUserAll();
}
