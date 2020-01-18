package com.pg.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pg.mall.bean.PmsProductImage;
import com.pg.mall.bean.PmsProductInfo;
import com.pg.mall.bean.PmsProductSaleAttr;
import com.pg.mall.bean.PmsProductSaleAttrValue;
import com.pg.mall.manage.mapper.PmsProductImageMapper;
import com.pg.mall.manage.mapper.PmsProductInfoMapper;
import com.pg.mall.manage.mapper.PmsProductSaleAttrMapper;
import com.pg.mall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.pg.mall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: spu实现类
 * @author: pg_7
 * @create: 2020-01-12 19:56
 **/
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    /**
     * @param catelogId
     * @Description: 根据3集分类id 查询所有商品
     * @Param: [catelogId]
     * @return: java.util.List<com.pg.mall.bean.PmsProductInfo>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @Override
    public List<PmsProductInfo> getSpuList(String catelogId) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catelogId);
        return pmsProductInfoMapper.select(pmsProductInfo);
    }

    /**
     * @param pmsProductInfo
     * @Description: 添加PmsProductInfo 商品spu抽象信息 附带平台销售属性集合（平台自定义属性）
     * 和 上架销售属性集合（入驻平台的商户的销售属性） 附带图片信息组成spu
     * @Param: [pmsProductInfo]
     * @return: void
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        // 保存商品信息
        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        // 生成商品主键
        String productId = pmsProductInfo.getId();

        // 保存商品图片信息
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        // 保存销售属性信息
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

            // 保存销售属性值
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }


    }

    /**
     * @param spuId
     * @Description: 根据商品id 查询商家销售属性对应销售属性值的集合
     * @Param: [spuId]
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);
        for (PmsProductSaleAttr productSaleAttr : pmsProductSaleAttrList) {

            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            //根据商品spuid和 对应平台商家属性id查询
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(productSaleAttr.getSaleAttrId());
            // 销售属性id用的是系统的字典表中id，不是销售属性表的主键
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            productSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValueList);
        }
        return pmsProductSaleAttrList;
    }

    /**
     * @param spuId
     * @Description: 根据spuID商品抽象销售单元标准id查询图片集合
     * @Param: [spuId]
     * @return: java.util.List<com.pg.mall.bean.PmsProductImage>
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        return pmsProductImageMapper.select(pmsProductImage);


    }

    /**
     * @param productId
     * @param skuId
     * @Description: 根据商品skuid 查询所有队形的销售属性集合
     * @Param: [id]
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/17
     */
    @Override
    public List<PmsProductSaleAttr> getSaleAttrListCheckBySku(String productId, String skuId) {
      /*  PmsProductSaleAttr pmsProductSaleAttr =new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(productId);
        List<PmsProductSaleAttr> saleAttrList = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);
        for (PmsProductSaleAttr productSaleAttr : saleAttrList) {
            String saleAttrId = productSaleAttr.getSaleAttrId();
            PmsProductSaleAttrValue productSaleAttrValue =new PmsProductSaleAttrValue();

            productSaleAttrValue.setSaleAttrId(saleAttrId);
            productSaleAttrValue.setProductId(productId);

            List<PmsProductSaleAttrValue> saleAttrValueList = pmsProductSaleAttrValueMapper.select(productSaleAttrValue);
            productSaleAttr.setSpuSaleAttrValueList(saleAttrValueList);

        }*/
        return pmsProductSaleAttrMapper.selectSpuSaleAttrListCheckBySku(productId, skuId);

    }

}
