package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @program: PG-MALL
 * @description:搜索词典
 * @author: pg_7
 * @create: 2020-01-21 01:34
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsSearchSkuInfo implements Serializable {
    @Id
    private String id;
    private String skuName;
    private String skuDesc;
    private String catalog3Id;
    private BigDecimal price;
    private String skuDefaultImg;
    private double hotScore;
    private String productId;
    private List<PmsSkuAttrValue> skuAttrValueList;
}
