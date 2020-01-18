package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.io.Serializable;
/**
 *
 *
 * @Description: 三级类目
 * @Param:
 * @return:
 * @Author: pg-7
 * @Date: 2020/1/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsBaseCatalog3 implements Serializable {

    @Id
    private String id;
    private String name;
    private String catalog2Id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(String catalog2Id) {
        this.catalog2Id = catalog2Id;
    }
}
