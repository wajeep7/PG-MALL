package com.pg.mall.service;

import com.pg.mall.bean.PmsBaseAttrInfo;
import com.pg.mall.bean.PmsBaseAttrValue;
import com.pg.mall.bean.PmsBaseSaleAttr;

import java.util.List;
import java.util.Set;

public interface AttrService {

    /**
     *
     *
     * @Description: 根据3级类目id 查询对应属性信息
     * @Param: [catalog3Id]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseAttrInfo>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
    /**
     *
     *
     * @Description: 根据表单修改或添加属性平台 和属性值
     * @Param: [pmsBaseAttrInfo]
     * @return: java.lang.String
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    /**
     *
     *
     * @Description: 根据attrId 查询所有属性值的集合
     * @Param: [attrId]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseAttrValue>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    /**
     *
     *
     * @Description: 查询所有商家自定义销售属性
     * @Param: []
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/13
     */
    List<PmsBaseSaleAttr> baseSaleAttrList();


    /**
     *
     *
     * @Description: 属性值去重显示
     * @Param: [valueIdSet]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseAttrInfo>
     * @Author: pg-7
     * @Date: 2020/1/21
     */
    List<PmsBaseAttrInfo> getAttrValueListByValueId(Set<String> valueIdSet);
}
