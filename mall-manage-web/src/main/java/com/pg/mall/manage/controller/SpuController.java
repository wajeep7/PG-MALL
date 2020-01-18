package com.pg.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pg.mall.bean.PmsProductImage;
import com.pg.mall.bean.PmsProductInfo;
import com.pg.mall.bean.PmsProductSaleAttr;
import com.pg.mall.service.SpuService;
import com.pg.mall.utils.MallUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: spu商品控制层
 * @author: pg_7
 * @create: 2020-01-12 19:48
 **/
@CrossOrigin
@Controller
@Slf4j
public class SpuController {
    @Reference
    private SpuService spuService;
    /**
     * @param spuId
     * @Description: 根据商品id 查询商家销售属性对应销售属性值的集合 备注vue没有单独分陌路爱
     * @Param: [spuId]
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {

        return spuService.spuSaleAttrList(spuId);
    }



    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId) {
        return spuService.spuImageList(spuId);
    }






    /**
     *
     *
     * @Description: 保存所有的spu结构商品信息
     * @Param: [pmsProductInfo]
     * @return: java.lang.String
     * @Author: pg-7
     * @Date: 2020/1/15
     */

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpu(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    /**
     *
     *
     * @Description:  文件上传前台代码回调给save 方法 返回上传图片集合
     * @Param: [multipartFile]
     * @return: java.lang.String
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        String imgUrl = MallUploadUtils.uploadImage(multipartFile);

        log.info("图片路径为{}", imgUrl);

        return imgUrl;
    }

    /**
     * @Description: 根据商品分类3级别id 查询具体商品
     * @Param: [catelogId]
     * @return: java.util.List<com.pg.mall.bean.PmsProductInfo>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catelogId) {
        return spuService.getSpuList(catelogId);
    }


}
