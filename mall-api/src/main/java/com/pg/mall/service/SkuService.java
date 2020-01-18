package com.pg.mall.service;

import com.pg.mall.bean.PmsSkuInfo;

import java.util.List;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-15 18:41
 **/
public interface SkuService {
    /**
     *
     *
     * @Description: 后台sku规格商品入库
     * @Param: [pmsSkuInfo]
     * @return: void
     * @Author: pg-7
     * @Date: 2020/1/16
     */
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     *
     *
     * @Description: 前台商品展示sku 信息 sku 标题 sku 图片
     * @Param: [skuId]
     * @return: com.pg.mall.bean.PmsSkuInfo
     * @Author: pg-7
     * @Date: 2020/1/16
     */
    PmsSkuInfo getSkuById(String skuId);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
}
