package com.pg.mall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.pg.mall.bean.PmsProductSaleAttr;
import com.pg.mall.bean.PmsSkuInfo;
import com.pg.mall.bean.PmsSkuSaleAttrValue;
import com.pg.mall.service.SkuService;
import com.pg.mall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PG-MALL
 * @description: spu+sku=item
 * @author: pg_7
 * @create: 2020-01-16 16:14
 **/
@Controller
public class ItemController {
    @Reference
    private SkuService skuService;

    @Reference
    private SpuService spuService;

    /**
     * @Description: sku展示模块 单品页
     * @Param: [modelMap]
     * @return: java.lang.String
     * @Author: pg-7
     * @Date: 2020/1/16
     */
    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap) {
        PmsSkuInfo PmsSkuInfo = skuService.getSkuById(skuId);
        modelMap.put("skuInfo", PmsSkuInfo);
        List<PmsProductSaleAttr> saleAttrList = spuService.getSaleAttrListCheckBySku(PmsSkuInfo.getProductId(), PmsSkuInfo.getId());
        modelMap.put("spuSaleAttrListCheckBySku", saleAttrList);
        //存放商品销售属性值设置 k 和 skuid 为值
        Map<String, String> skuSaleSkuIDHash = new HashMap<>();

        //根据查询出的skuin表中的商品id 推出 商品属性 一个spu 有多个sku 推出sku
        List<PmsSkuInfo> skuInfoList = skuService.getSkuSaleAttrValueListBySpu(PmsSkuInfo.getProductId());
        for (PmsSkuInfo skuInfo : skuInfoList) {
            //存储前台销售属性id通过 skuinfo 推出每个skuid 对应的商家销售属性
            String k = "";
            String v = skuInfo.getId(); //值为skuid
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();//键商家销售属性 集合 设置为键
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";// "239|245"//根据sku销售属性值设置的key

            }
            skuSaleSkuIDHash.put(k, v);//一个skuID 有多个键
        }
        //将设置将商品销售属性值id 设的的key 和skuid设置的值存放到页面上 的哈希表 以json的格式放入

        String mapToJson = JSON.toJSONString(skuSaleSkuIDHash);
        modelMap.put("saleValueKV", mapToJson);


        return "item";
    }


    /*测试*/
    @RequestMapping("/index")
    //@ResponseBody
    public String index(ModelMap modelMap) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("虚幻数据" + i);
        }
        modelMap.put("list", list);
        modelMap.put("pgnb", "平哥牛逼");
        modelMap.put("check", 1);
        return "index";
    }


}
