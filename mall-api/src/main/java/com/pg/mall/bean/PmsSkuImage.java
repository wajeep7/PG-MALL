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
 * @create: 2020-01-15 18:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsSkuImage implements Serializable {
    @Id
    @Column
    String id;
    @Column
    String skuId;
    @Column
    String imgName;
    @Column
    String imgUrl;
    @Column
    String spuImgId;
    @Column
    String isDefault;
}
