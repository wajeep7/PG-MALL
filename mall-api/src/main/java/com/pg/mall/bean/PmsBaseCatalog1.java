package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 *
 * @Description: 一级类目
 * @Param:
 * @return:
 * @Author: pg-7
 * @Date: 2020/1/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsBaseCatalog1 implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @Transient
    private List<PmsBaseCatalog2> catalog2s;

}

