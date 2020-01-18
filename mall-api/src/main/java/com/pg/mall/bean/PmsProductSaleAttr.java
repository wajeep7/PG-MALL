package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @program: PG-MALL
 * @description:商品属性表
 * @author: pg_7
 * @create: 2020-01-12 19:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsProductSaleAttr implements Serializable {

    @Id
    @Column
    String id;

    @Column
    String productId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrName;
    @Transient
    List<PmsProductSaleAttrValue> spuSaleAttrValueList;
}
