package com.pg.mall.service;


import com.pg.mall.bean.UmsMember;
import com.pg.mall.bean.UmsMemberReceiveAddress;

import java.util.List;
public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
