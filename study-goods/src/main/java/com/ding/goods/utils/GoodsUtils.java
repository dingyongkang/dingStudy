package com.ding.goods.utils;

import org.springframework.util.StringUtils;

public class GoodsUtils {
    /**
     * 获取文件扩展名
     * @param path
     * @return
     */
    public static String getExtension(String path){
        String filenameExtension = StringUtils.getFilenameExtension(path);
        return filenameExtension;
    }

}
