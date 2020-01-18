package com.pg.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pg.mall.bean.PmsSkuInfo;
import com.pg.mall.service.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: PG-MALL
 * @description: 商品sku属性控制层
 * @author: pg_7
 * @create: 2020-01-15 18:35
 **/
@Controller
@CrossOrigin
public class SkuController {
    @Reference
    private SkuService skuService;

    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if (StringUtils.isBlank(skuDefaultImg)) {
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }
        System.out.println("saaaaaaaaaaaaaaaaaaa________________________________");


        skuService.saveSkuInfo(pmsSkuInfo);

        return "success";

    }

}
