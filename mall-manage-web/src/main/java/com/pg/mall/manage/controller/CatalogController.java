package com.pg.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pg.mall.bean.PmsBaseCatalog1;
import com.pg.mall.bean.PmsBaseCatalog2;
import com.pg.mall.bean.PmsBaseCatalog3;
import com.pg.mall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
/*后台跨域注解*/
@CrossOrigin
public class CatalogController {

    /*远程接口注解 可以调用远程接口*/
    @Reference
    private CatalogService catalogService;

    /**
     * @Description: 一级分类
     * @Param: []
     * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog1>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }

    /**
     * 二级分类
     *
     * @param catalog1Id
     * @return
     */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    /**
     * @Description: 三级分类
     * @Param: [catalog2Id]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseCatalog3>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }

}
