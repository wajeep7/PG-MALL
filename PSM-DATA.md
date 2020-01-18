
spring.dubbo.registry.address=192.168.1.103:2181

#一 系统名称 MALL-MANGER 商城后台管理系统
#二数据机构pms：商品管理数据表格的数据结构划分
1、sku+spu
2、sku:商品库存储存的单元 只具体存储一件品牌商品 苹果7 土豪金 128g 这就是sku库存单元
3、spu:商品抽象标准可复用的最小商品单元 苹果7手机系列
4、sku 结构 持久化库 以pms_sku_ 开头
5、spu 机构 持久化库 以pms_spu_ 开头
6、类目的结构 pms_base_catalog 开头 
分为3级处理 
{1level(1，手机),
 2level(1，手机通讯,1), 
       (2，手机配件,1),
       (3,手机运营商,1),
 3level(1,手机耳机,2),
       (2,手机贴膜,2),
       (3,序号中心,3),
       (4,办理套餐,3)}  
2级类目对应1级类目1levelid
3级类目对应2级类目2levelid
7、pms_attr_
