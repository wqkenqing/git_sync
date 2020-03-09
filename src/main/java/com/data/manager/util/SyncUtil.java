package com.data.manager.util;

import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import util.CommonUtil;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @className: SyncUtil
 * @author: kuiq.wang
 * @date: 2020/3/9 3:51 下午
 **/
public class SyncUtil extends CommonUtil {
    static String basePath = "/Users/wqkenqing/Desktop/文档/日常文档/dayliy_doc/技术";

    public void fileOperate(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files.length > 0) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        fileOperate(f.getAbsolutePath());
                    } else {
//                        System.out.println(f.getAbsolutePath());
                        System.out.println(pathRename(f.getAbsolutePath(), basePath));
                    }
                }
            }
        }
    }

    public String pathRename(String path, String basePath) {
        String remainPath = path.replace(basePath, "");
        remainPath = remainPath.replace("/", "#");

        return remainPath;
    }

    public static void main(String[] args) {
        SyncUtil util = new SyncUtil();
        util.fileOperate(basePath);
    }

}
