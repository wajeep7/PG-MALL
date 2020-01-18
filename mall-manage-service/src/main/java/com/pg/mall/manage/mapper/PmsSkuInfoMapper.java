package com.pg.mall.manage.mapper;

import com.pg.mall.bean.PmsSkuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-15 19:20
 **/
public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo> {
    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(String productId);
}
