package com.pg.mall.search.service.impl;

import com.pg.mall.bean.PmsSearchParam;
import com.pg.mall.bean.PmsSearchSkuInfo;
import com.pg.mall.service.SearchService;
import io.searchbox.client.JestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: 搜索引擎实现类
 * @author: pg_7
 * @create: 2020-01-21 09:29
 **/
public class SearchServiceImpl implements SearchService {
    @Autowired
    JestClient jestClient;

    @Override
    public List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam) {

        return null;
    }
}
