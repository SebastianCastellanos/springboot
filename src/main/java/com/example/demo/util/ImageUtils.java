package com.example.demo.util;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author XiongZiQi
 */
public class ImageUtils {
    /**
     * 存储base64字符串的图片
     *
     * @param base64Str ImageBase64的字符串
     * @param path      存储路径
     * @param ext       图片后缀
     * @return ImageName
     */
    public static void base64CodeTobeImage(String base64Str, String path, String ext) {
        //创建文件对象
        File file = new File(path);
        //创建存储文件夹
        boolean dirs = file.mkdirs();
        //创建base64解码对象
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //字符串转为base64
            byte[] buffer = decoder.decodeBuffer(base64Str);
            //错误字节处理
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] < 0) {
                    buffer[i] += 256;
                }
            }
            //存储路径+ImageName；创建流对象；
            String imgFile = path + ext;
            OutputStream out = new FileOutputStream(imgFile);
            //写入磁盘
            out.write(buffer);
            out.flush();//刷新缓冲区
            out.close();//关闭IO流
            //返回图片名称
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
