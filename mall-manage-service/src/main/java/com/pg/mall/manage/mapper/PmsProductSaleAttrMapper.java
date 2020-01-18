package com.pg.mall.manage.mapper;

import com.pg.mall.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-13 12:50
 **/
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {
    /**
     *
     *
     * @Description: 根据商品skuid 查询所有队形的销售属性集合
     * @Param: [id]
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/17
     */
    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("productId") String productId, @Param("skuId") String skuId);


}
