package com.pg.mall.service;

import com.pg.mall.bean.PmsProductImage;
import com.pg.mall.bean.PmsProductInfo;
import com.pg.mall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-12 19:51
 **/
public interface SpuService {

    /**
     *
     *
     * @Description: 根据3集分类id 查询所有商品
     * @Param: [catelogId]
     * @return: java.util.List<com.pg.mall.bean.PmsProductInfo>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    List<PmsProductInfo> getSpuList(String catelogId);

    /**
     *
     *
     * @Description:  添加PmsProductInfo 商品spu抽象信息 附带平台销售属性集合（平台自定义属性）
     * 和 上架销售属性集合（入驻平台的商户的销售属性） 附带图片信息组成spu
     * @Param: [pmsProductInfo]
     * @return: void
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    
    
    /**
     *
     *
     * @Description: 根据商品id 查询商家销售属性对应销售属性值的集合
     * @Param: [spuId] 
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr> 
     * @Author: pg-7 
     * @Date: 2020/1/15 
     */ 
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    /**
     *
     *
     * @Description: 根据spuID商品抽象销售单元标准id查询图片集合
     * @Param: [spuId]
     * @return: java.util.List<com.pg.mall.bean.PmsProductImage>
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    List<PmsProductImage> spuImageList(String spuId);

    /**
     *
     *
     * @Description: 根据商品skuid 查询所有队形的销售属性集合
     * @Param: [id]
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/17
     */
    List<PmsProductSaleAttr> getSaleAttrListCheckBySku(String productId,String skuId);
}
