package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-21 01:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PmsSearchParam implements Serializable {
    private String catalog3Id;

    private String keyword;

    private String[] valueId;
}
