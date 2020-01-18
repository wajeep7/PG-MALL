package com.pg.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pg.mall.bean.PmsBaseAttrInfo;
import com.pg.mall.bean.PmsBaseAttrValue;
import com.pg.mall.bean.PmsBaseSaleAttr;
import com.pg.mall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: 属性web层
 * @author: pg_7
 * @create: 2020-01-12 13:43
 **/
@Controller
@CrossOrigin
public class AttrController {
    @Reference
    private AttrService attrService;


    /**
     * @Description: 查询所有平台销售属性下对应的平台销售属性值
     * @Param: []
     * @return: java.util.List<com.pg.mall.bean.PmsBaseSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/15
     */
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList() {

        return attrService.baseSaleAttrList();
    }

    /**
     * @Description: 根据3及分类查询 所有平台属性集合，返回对应的平台属性集合；平台商家销售属性集合
     * 便利平台属性集合 里的主键查询出所有对应的商家属性值 根据商家属性值进行所有上架属性值集合的查询最后放入平台属性表里
     * @Param: [catalog3Id]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseAttrInfo>
     * @Author: pg-7
     * @Date: 2020/1/15
     */

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        return attrService.attrInfoList(catalog3Id);
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        return attrService.saveAttrInfo(pmsBaseAttrInfo);
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        return attrService.getAttrValueList(attrId);
    }


}
