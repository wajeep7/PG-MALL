package com.pg.mall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.pg.mall.bean.UmsMember;
import com.pg.mall.bean.UmsMemberReceiveAddress;
import com.pg.mall.service.UserService;
import com.pg.mall.user.mapper.UmsMemberReceiveAddressMapper;
import com.pg.mall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {

        return userMapper.selectAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        // 封装的参数对象
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
//        Example example = new Example(UmsMemberReceiveAddress.class);
//        example.createCriteria().andEqualTo("memberId",memberId);
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(example);

        return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
    }
}
