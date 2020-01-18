package com.pg.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pg.mall.bean.PmsBaseCatalog1;
import com.pg.mall.bean.PmsBaseCatalog2;
import com.pg.mall.bean.PmsBaseCatalog3;
import com.pg.mall.manage.mapper.PmsBaseCatalog1Mapper;
import com.pg.mall.manage.mapper.PmsBaseCatalog2Mapper;
import com.pg.mall.manage.mapper.PmsBaseCatalog3Mapper;
import com.pg.mall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    private PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    private PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    /**
     *
     *
     * @Description: 查询所有1级类目
     * @Param: []
     * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog1>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    /**
     *
     *
     * @Description: 根据id 查询所有2级请求
     * @Param: [catalog1Id]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog2>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
    }
    /**
     *
     *
     * @Description: 根据id 查询所有3级请求
     * @Param: [catalog1Id]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog2>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {

        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
    }
}
