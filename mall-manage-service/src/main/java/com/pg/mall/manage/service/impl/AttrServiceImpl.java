package com.pg.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pg.mall.bean.PmsBaseAttrInfo;
import com.pg.mall.bean.PmsBaseAttrValue;
import com.pg.mall.bean.PmsBaseSaleAttr;
import com.pg.mall.manage.mapper.PmsBaseAttrInfomMapper;
import com.pg.mall.manage.mapper.PmsBaseAttrValueMapper;
import com.pg.mall.manage.mapper.PmsBaseSaleAttrMapper;
import com.pg.mall.service.AttrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: PG-MALL
 * @description: 属性规格实现类
 * @author: pg_7
 * @create: 2020-01-12 13:51
 **/
@Service
@Slf4j
public class AttrServiceImpl implements AttrService {

    @Autowired
    private PmsBaseAttrInfomMapper pmsBaseAttrInfomMapper; //平台属性
    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper; //平台属性值
    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;//平台规定商家属性

    /**
     * @param catalog3Id
     * @Description: 根据3级类目id 查询对应属性信息
     * @Param: [catalog3Id]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseAttrInfo>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfomMapper.select(pmsBaseAttrInfo);
        for (PmsBaseAttrInfo baseAttrInfo : pmsBaseAttrInfos) {

            List<PmsBaseAttrValue> pmsBaseAttrValues = new ArrayList<>();
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(baseAttrInfo.getId());
            pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
            baseAttrInfo.setAttrValueList(pmsBaseAttrValues);
        }

        return pmsBaseAttrInfos;
    }

    /**
     * @param pmsBaseAttrInfo
     * @Description: 根据表单修改或添加属性平台 和属性值
     * @Param: [pmsBaseAttrInfo]
     * @return: java.lang.String
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String id = pmsBaseAttrInfo.getId();
        if(StringUtils.isBlank(id)){
            // id为空，保存
            // 保存属性
            pmsBaseAttrInfomMapper.insertSelective(pmsBaseAttrInfo);//insert insertSelective 是否将null插入数据库

            // 保存属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());

                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        }else{
            // id不空，修改

            // 属性修改
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            pmsBaseAttrInfomMapper.updateByExampleSelective(pmsBaseAttrInfo,example);


            // 属性值修改
            // 按照属性id删除所有属性值
            PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
            pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);

            // 删除后，将新的属性值插入
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }


        return "success";
    }

    /**
     * @param attrId
     * @Description: 根据attrId 查询所有属性值的集合
     * @Param: [attrId]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseAttrValue>
     * @Author: pg-7
     * @Date: 2020/1/12
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }

    /**
     * @Description: 查询所有商家自定义销售属性
     * @Param: []
     * @return: java.util.List<com.pg.mall.bean.PmsProductSaleAttr>
     * @Author: pg-7
     * @Date: 2020/1/13
     */
    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }

    /**
     * @param valueIdSet
     * @Description: 属性值去重显示
     * @Param: [valueIdSet]
     * @return: java.util.List<com.pg.mall.bean.PmsBaseAttrInfo>
     * @Author: pg-7
     * @Date: 2020/1/21
     */
    @Override
    public List<PmsBaseAttrInfo> getAttrValueListByValueId(Set<String> valueIdSet) {
        String valueIdStr = StringUtils.join(valueIdSet, ",");//41,45,46
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfomMapper.selectAttrValueListByValueId(valueIdStr);
        return pmsBaseAttrInfos;



    }


}
