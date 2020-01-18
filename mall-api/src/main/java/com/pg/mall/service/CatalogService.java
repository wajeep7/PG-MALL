package com.pg.mall.service;


import com.pg.mall.bean.PmsBaseCatalog1;
import com.pg.mall.bean.PmsBaseCatalog2;
import com.pg.mall.bean.PmsBaseCatalog3;

import java.util.List;
/**
 *
 *
 * @Description: 类目接口
 * @Param:
 * @return:
 * @Author: pg-7
 * @Date: 2020/1/12
 */
public interface CatalogService {
    /**
     *
     *
     * @Description: 查询一级类目所有信息
     * @Param: []
     * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog1>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    List<PmsBaseCatalog1> getCatalog1();
/**
 *
 *
 * @Description: 查询所有2级类目
 * @Param: [catalog1Id]
 * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog2>
 * @Author: pg-7
 * @Date: 2020/1/12
 */
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    /**
     *
     *
     * @Description: 查询所有3级类目
     * @Param: [catalog2Id]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog3>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
