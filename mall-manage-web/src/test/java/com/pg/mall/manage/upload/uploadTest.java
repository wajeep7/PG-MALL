package com.pg.mall.manage.upload;

import com.pg.mall.manage.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: PG-MALL
 * @description: 文件上传测试类
 * @author: pg_7
 * @create: 2020-01-14 23:45
 **/
@Slf4j
public class uploadTest extends BaseTest {

    @Test
    public void uploadTest1() throws IOException, MyException {
        System.out.println("_________________________________________________________________________________");
       //拿到同级tracker策略文件
        String trackerPath = BaseTest.class.getResource("/tracker.conf").getPath();
        log.info("路径是:{}",trackerPath);


       //初始化工具类
        ClientGlobal.init(trackerPath);
        //穿件客户端
        TrackerClient trackerClient=new TrackerClient();
        //通过客户端拿到服务
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        //放入trackerServer 管理存储服务器
        StorageClient storageClient = new StorageClient(trackerServer);
        //存储服务器那地址 进行解析 null为指定仓储路径
        String[] upload_files = storageClient.upload_file("D:\\图片\\li.jpg", "jpg", null);
        StringBuilder url= new StringBuilder("http://192.168.1.101");
        for (String upload_file : upload_files) {
            url.append("/").append(upload_file);
        }

        log.info("图片路径为{}", url);
    }
}
