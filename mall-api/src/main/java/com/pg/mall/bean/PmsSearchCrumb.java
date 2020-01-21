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
 * @create: 2020-01-21 01:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsSearchCrumb implements Serializable {
    private String valueId;
    private String valueName;
    private String urlParam;
}
