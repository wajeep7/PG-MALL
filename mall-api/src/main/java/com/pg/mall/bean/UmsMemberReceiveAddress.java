package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.io.Serializable;
/**
 *
 *
 * @Description: 用户地址表
 * @Param:
 * @return:
 * @Author: pg-7
 * @Date: 2020/1/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UmsMemberReceiveAddress implements Serializable {
    @Id
    private String id;
    private String memberId;
    private String name;
    private String phoneNumber;
    private int defaultStatus;
    private String postCode;
    private String province;
    private String city;
    private String region;
    private String detailAddress;

}