package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-12 19:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsProductSaleAttrValue implements Serializable{
    @Id
    @Column
    private String id ;

    @Column
    private String productId;

    @Column
    private String saleAttrId;

    @Column
    private String saleAttrValueName;

    @Transient
    private String isChecked;
}
