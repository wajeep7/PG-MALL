package com.pg.mall.service;


import com.pg.mall.bean.PmsSearchParam;
import com.pg.mall.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
