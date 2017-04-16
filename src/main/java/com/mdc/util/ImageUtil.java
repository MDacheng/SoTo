package com.mdc.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by mengdacheng on 2017/4/14.
 */
public class ImageUtil {
    /**
     * 获取指定路径的文件
     * @param url
     * @return
     */
    public static Image getImage(String url){
        Image image = null;
        try {
            URLConnection connection = new URL(url).openConnection();
            image = ImageIO.read(connection.getInputStream());
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return image;
    }
    public static Image getCompressImage(String url, double propertion){
        Image image = getImage(url);
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        //insert code...
        return null;
    }
    /**
     * 将指定路径的文件写入到输出流
     * @param url
     * @param outputStream
     * @throws IOException
     */
    public static void writeImage(String url, OutputStream outputStream) throws IOException{
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream inputStream = connection.getInputStream();
            if(inputStream != null) {
                int len;
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer)) != -1)
                    outputStream.write(buffer, 0, len);
                outputStream.flush();
                inputStream.close();
            }
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }
    }
}
