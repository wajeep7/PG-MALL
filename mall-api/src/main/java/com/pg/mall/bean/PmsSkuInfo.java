package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-15 18:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsSkuInfo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;
    @Column
    String productId;
    @Transient
    String spuId;
    @Column
    BigDecimal price;
    @Column
    String skuName;
    @Column
    BigDecimal weight;
    @Column
    String skuDesc;
    @Column
    String catalog3Id;
    @Column
    String skuDefaultImg;
    @Transient
    List<PmsSkuImage> skuImageList;
    @Transient
    List<PmsSkuAttrValue> skuAttrValueList;
    @Transient
    List<PmsSkuSaleAttrValue> skuSaleAttrValueList;
}
