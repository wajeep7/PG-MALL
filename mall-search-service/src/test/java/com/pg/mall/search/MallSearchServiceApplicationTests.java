package com.pg.mall.search;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pg.mall.bean.PmsSearchSkuInfo;
import com.pg.mall.bean.PmsSkuInfo;
import com.pg.mall.service.SkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSearchServiceApplicationTests {

    @Reference
    private SkuService skuService;

    @Autowired
    private JestClient jestClient;



    @Test
    public void getSearch() throws IOException {
        List<PmsSearchSkuInfo>searchSkuInfoList = new ArrayList<>();

        Search search = new Search.Builder("{\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"filter\": [\n" +
                "        {\"terms\":{\"skuAttrValueList.valueId\":[\"54\",\"41\",\"44\"]}}\n" +
                "        ,\n" +
                "        {\"term\":{\"skuAttrValueList.valueId\":\"54\"}},\n" +
                "        {\"term\":{\n" +
                "         \"skuAttrValueList.valueId\":\"58\"\n" +
                "        }\n" +
                "        }  \n" +
                "      ],\n" +
                "      \"must\": [\n" +
                "        {\n" +
                "          \"match\": {\n" +
                "            \"skuName\": \"平哥\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}").addIndex("pgmall").addType("PmsSkuInfo").build();
        SearchResult execute = jestClient.execute(search);
        Long total = execute.getTotal();//查询总数
        /*头为hits 下面包含source*/
        List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = execute.getHits(PmsSearchSkuInfo.class);
        for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
                PmsSearchSkuInfo pmsSearchSkuInfo=hit.source;//通过source 得到具体查询结果对象
                //将查询出来的对象词典放入集合中
                searchSkuInfoList.add(pmsSearchSkuInfo);
        }
        //得到查询条件过滤后的集合
        System.out.println("__________________________________________________________________");
        System.out.println(searchSkuInfoList.size());

    }















    @Test
    public void contextLoads() throws IOException {
        //1 查询sql 数据
        //查询所有skuinfo 商品 包含所有属性id 和 所有属性值id 关联skuid 中间白哦 关联sku销售属性和销售属性值
        List<PmsSkuInfo> pmsSkuInfoList = skuService.getAllSku();
        List<PmsSearchSkuInfo> pmsSearchSkuInfoList = new ArrayList<>();
        for (PmsSkuInfo pmsSkuInfo : pmsSkuInfoList) {
            PmsSearchSkuInfo PmsSearchSkuInfo = new PmsSearchSkuInfo();
            BeanUtils.copyProperties(pmsSkuInfo, PmsSearchSkuInfo);
            pmsSearchSkuInfoList.add(PmsSearchSkuInfo);
        }
        DocumentResult execute = null;
        //2导入es 库
        for (PmsSearchSkuInfo pmsSearchSkuInfo : pmsSearchSkuInfoList) {
            Index put = new Index.Builder(pmsSearchSkuInfo).index("pgmall").type("PmsSkuInfo").id(pmsSearchSkuInfo.getId()).build();
            execute = jestClient.execute(put);
        }

        System.out.println(execute);
    }

    @Test
    public void get() throws IOException {

        // jest的dsl工具
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        // filter
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("skuAttrValueList.valueId", "49");
        boolQueryBuilder.filter(termQueryBuilder);
        // must
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("skuName", "李沁黑丝一人份");
        boolQueryBuilder.must(matchQueryBuilder);
        // query
        searchSourceBuilder.query(boolQueryBuilder);
        // from
        searchSourceBuilder.from(0);
        // size
        searchSourceBuilder.size(20);
        // highlight
        searchSourceBuilder.highlight(null);

        String dslStr = searchSourceBuilder.toString();

        System.err.println(dslStr);


        // 用api执行复杂查询
        List<PmsSearchSkuInfo> pmsSearchSkuInfos = new ArrayList<>();

        Search search = new Search.Builder(dslStr).addIndex("pgmall").addType("PmsSkuInfo").build();

        SearchResult execute = jestClient.execute(search);

        List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = execute.getHits(PmsSearchSkuInfo.class);

        for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
            PmsSearchSkuInfo source = hit.source;

            pmsSearchSkuInfos.add(source);
        }

        System.out.println(pmsSearchSkuInfos.size());
    }


}
