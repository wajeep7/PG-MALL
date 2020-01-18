package com.pg.mall.utils;

import com.pg.mall.constants.UploadConstants;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: PG-MALL
 * @description:
 * @author: pg_7
 * @create: 2020-01-15 00:36
 **/
public class MallUploadUtils {

    public static String uploadImage(MultipartFile multipartFile) {
        StringBuilder trackerImgUploadPath = new StringBuilder(UploadConstants.TRACKER_IMG_UPLOAD_PATH);
        try {
            ClientGlobal.init(UploadConstants.TRACKER_CONF);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StorageClient storageClient = new StorageClient(trackerServer, null);
        try {
            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);
            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);
            for (String uploadInfo : uploadInfos) {
                trackerImgUploadPath.append("/").append(uploadInfo);
            }
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return String.valueOf(trackerImgUploadPath);

    }
}
