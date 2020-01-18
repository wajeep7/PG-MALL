package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @Description: 属性初始化表  商品具体信号下的规格属性id 表
 * @Param:  catalog3Id; 是三级类目表的属性连接表
 * @return:  
 * @Author: pg-7 
 * @Date: 2020/1/12 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsBaseAttrInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;
    @Column
    private String isEnabled;
    @Transient
    List<PmsBaseAttrValue> attrValueList;
}
