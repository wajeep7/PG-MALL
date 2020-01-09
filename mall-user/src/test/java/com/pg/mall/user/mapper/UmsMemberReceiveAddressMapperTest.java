package com.pg.mall.user.mapper;

import com.pg.mall.user.BaseTest;
import com.pg.mall.user.bean.UmsMemberReceiveAddress;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UmsMemberReceiveAddressMapperTest extends BaseTest {
    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Test
    public void selectByPrimaryKey() {
        UmsMemberReceiveAddress umsMemberReceiveAddress = umsMemberReceiveAddressMapper.selectByPrimaryKey(1L);
        System.out.println(umsMemberReceiveAddress);
    }
}