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
 * @description:商品图片信息表
 * @author: pg_7
 * @create: 2020-01-12 19:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsProductImage implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String productId;
    @Column
    private String imgName;
    @Column
    private String imgUrl;

}
