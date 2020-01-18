package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-15 18:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsSkuSaleAttrValue implements Serializable {
    @Id
    @Column
    String id;

    @Column
    String skuId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrValueId;

    @Column
    String saleAttrName;

    @Column
    String saleAttrValueName;
}
