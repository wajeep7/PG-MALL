#PG-MALL 电商项目
PMS 数据结构 
商品管理系统 pms 全译
主要结构为sku spu 
spu 是苹果手机 是商品抽象标准可复用的最小单位 苹果7手机
sku 是具体入库存储的具体单位信息。苹果7手机 土豪金 128g 这就是sku库存单元 

#端口 用户
mall-user-service prot:8070
mall-user-web prot:8080

#端口 后台管理
mall-manage-service prot:8072
mall-manage-web prot:8081

#前台item 
server.port=8082


#service 搜索
server.port=8073
server.web = 8083




#mall-api主要作用： 提供接口 和bean 
#mall-parent主要作用：管理所有maven 一栏版本号
#mall-user主要作用：用户模块 使用itbatis 泛型 mapper 到层方法。少量配置mapper 映射文件



#mall-common-util主要作用 ：管理业务逻辑service服务层/web前端船里曾controller 所需要的依赖
spring-boot-starter-test	测试
spring-boot-starter-web	    内含tomcat容器、HttpSevrletRequest等 springboot默认版本号
fastjson	                json工具
commons-lang3	            方便好用的apache工具库
commons-beanutils	        方便好用的apache处理实体bean工具库
commons-codec	            方便好用的apache解码工具库
httpclient	restful调用客户端

#mall-service-util 主要作用 ：管理后端业务层数据库 jdbc mybatis 的连接
spring-boot-starter-jdbc	数据库驱动(springboot有默认版本号)
mysql-connector-java	数据库连接器(springboot有默认版本号)
mybatis-spring-boot-starter	mybatis