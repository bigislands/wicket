package com.pspot.wicket;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.*;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/5/5
 */
public class ImageTest {

    @Test
    public void test_a(){
            try {
                String str = zipImageFile("/Users/yuchen/yq.JPG"
                        ,512
                        ,512
                        ,1f
                        ,"x2");
                FileUtils.writeStringToFile(new File("/Users/yuchen/bbb.jpg"),str);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }



    public static String zipImageFile(String oldFile, int width, int height,
                                      float quality, String smallIcon) {
        if (oldFile == null) {
            return null;
        }
        String newImage = null;
        try {
            /**对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(new File(oldFile));
            /** 宽,高设定 */
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
            String filePrex = oldFile.substring(0, oldFile.indexOf('.'));
            /** 压缩后的文件名 */
            newImage = filePrex + smallIcon + oldFile.substring(filePrex.length());
            /** 压缩之后临时存放位置 */
            FileOutputStream out = new FileOutputStream(newImage);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
            /** 压缩质量 */
            jep.setQuality(quality, true);
            encoder.encode(tag, jep);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newImage;
    }




    /*
     * 图片按比率缩放
     * size为文件大小
     */
//    public static void zoomImage(String src,String dest) throws Exception {
//        File srcFile = new File(src);
//        File destFile = new File(dest);
//
//        BufferedImage bufImg = ImageIO.read(srcFile);
//
//        Double width = 512.00/(bufImg.getWidth());
//        Double height = 512.00/(bufImg.getHeight());
//
//        Image itemp = bufImg.getScaledInstance(width,height, bufImg.SCALE_SMOOTH);
//
//        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(width, height), null);
//        itemp = ato.filter(bufImg, null);
//
//        try {
//            ImageIO.write((BufferedImage) itemp,dest.substring(dest.lastIndexOf(".")+1), destFile);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public static void zoomImage(String src,String dest,int w,int h) throws Exception {

        double wr=0,hr=0;
        File srcFile = new File(src);
        File destFile = new File(dest);

        BufferedImage bufImg = ImageIO.read(srcFile); //读取图片
        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);//设置缩放目标图片模板

        wr=w*1.0/bufImg.getWidth();     //获取缩放比例
        hr=h*1.0 / bufImg.getHeight();

        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile); //写入缩减后的图片
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
