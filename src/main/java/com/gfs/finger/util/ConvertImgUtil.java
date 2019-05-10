package com.gfs.finger.util;

import java.io.*;

/**
 * Created by liukai on 2018/10/30.
 */
public class ConvertImgUtil {

    public static native byte[] convertImg(byte[] jbyteArray,  boolean jboolean);

    /*static {
        System.loadLibrary("java_convertImg_cq64");
    }*/


    public static void main(String[] args){
        ConvertImgUtil convertImgUtil = new ConvertImgUtil();
        File[] files = new File("d:\\cqgq20181227").listFiles();

        for(File file:files){
            byte[] image = convertImgUtil.convertImg(convertImgUtil.getBytes(file),true);
            //convertImgUtil.getFile(image,"d://","11111.jpg");
            System.out.println("通过"+file.getName()+"生成11111.jpg");
        }
        System.out.println("fdsafdsa");


    }

    /**
     * 获得指定文件的byte数组
     */
    public byte[] getBytes(File file){
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public void getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+"/"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
