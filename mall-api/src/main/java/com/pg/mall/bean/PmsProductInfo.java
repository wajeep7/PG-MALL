package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: spu -结构商品主表
 * @Param:
 * @return:
 * @Author: pg-7
 * @Date: 2020/1/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsProductInfo implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String productName;

    @Column
    private String description;

    @Column
    private String catalog3Id;
    //游离态数据
    @Transient
    private List<PmsProductSaleAttr> spuSaleAttrList;
    @Transient
    private List<PmsProductImage> spuImageList;


}


