package com.pg.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.pg.mall.bean.PmsSkuAttrValue;
import com.pg.mall.bean.PmsSkuImage;
import com.pg.mall.bean.PmsSkuInfo;
import com.pg.mall.bean.PmsSkuSaleAttrValue;
import com.pg.mall.manage.mapper.PmsSkuAttrValueMapper;
import com.pg.mall.manage.mapper.PmsSkuImageMapper;
import com.pg.mall.manage.mapper.PmsSkuInfoMapper;
import com.pg.mall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.pg.mall.service.SkuService;
import com.pg.mall.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @program: PG-MALL
 * @description: sku结构服务层
 * @author: pg_7
 * @create: 2020-01-15 18:42
 **/
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private PmsSkuInfoMapper skuInfoMapper;
    @Autowired
    private PmsSkuImageMapper skuImageMapper;
    @Autowired

    private PmsSkuAttrValueMapper skuAttrValueMapper;
    @Autowired
    private PmsSkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    private RedisUtil redisUtil;
    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        // 插入skuInfo
        int i = skuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            skuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            skuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            skuImageMapper.insertSelective(pmsSkuImage);
        }

        // 发出商品的缓存同步消息
        // 发出商品的搜索引擎的同步消息


    }
    /**
     *
     *
     * @Description: 根据skuid 获得sku 信息并且根据skuid查询出 所有sku 相关图片信息
     * @Param: [skuId]
     * @return: com.pg.mall.bean.PmsSkuInfo
     * @Author: pg-7
     * @Date: 2020/1/18
     */
    public PmsSkuInfo getSkuByIdFromDB(String skuId) {
        PmsSkuInfo pmsSkuInfoDto =new PmsSkuInfo();
        pmsSkuInfoDto.setId(skuId);
        PmsSkuInfo pmsSkuInfo = skuInfoMapper.selectOne(pmsSkuInfoDto);
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> pmsSkuImageList = skuImageMapper.select(pmsSkuImage);
        pmsSkuInfo.setSkuImageList(pmsSkuImageList);
        return pmsSkuInfo;
    }

    /**
     *
     *
     * @Description: 缓存查询
     * @Param: [skuId]
     * @return: com.pg.mall.bean.PmsSkuInfo
     * @Author: pg-7
     * @Date: 2020/1/18
     */
    @Override
    public PmsSkuInfo getSkuById(String skuId) {
        PmsSkuInfo pmsSkuInfo =new PmsSkuInfo();


        //连接缓存
        Jedis jedis = redisUtil.getJedis();

        //查询缓存 取值
        String key = "sku:"+skuId+"info"; //设计的redis 键
        String skuJson = jedis.get(key);

        //如果根据key 获得值不是空的
        if (StringUtils.isNotBlank(skuJson)){
            pmsSkuInfo= JSON.parseObject(skuJson, PmsSkuInfo.class);

        }else {
            //如果缓存没有查询db 数据库 调用的是当前方法
            pmsSkuInfo = getSkuByIdFromDB(skuId);
            //数据库查询结果不为空存入redis db结果存入redis中
            if (pmsSkuInfo!=null){
                jedis.set("sku:"+skuId+"inif",JSON.toJSONString(pmsSkuInfo)); //存放成json 字符串存入
            }
            //防止穿透 如果数据库查询结果也是空
            else {
                //存入键 并且设置过期时间 3分钟 3分钟以内失效 不会进入数据库。返回给页面 为“”
                jedis.setex("skuId"+skuId+"info",60*3,JSON.toJSONString(""));
            }



        }


        //无论如何都要关闭资源
        jedis.close();




        //skuInfo初始信息
        return pmsSkuInfo;


    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        return skuInfoMapper.selectSkuSaleAttrValueListBySpu(productId);    }


}
