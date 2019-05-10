package com.gfs.finger.util;

/**
 * Created by liukai on 2018/10/30.
 */
public class ConvertImgUtil {

    public static native byte[] convertImg(byte[] jbyteArray,  boolean jboolean);

    /*static {
        System.loadLibrary("java_convertImg_cq64");
    }*/


    public static void main(String[] args){
        /*ConvertImgUtil convertImgUtil = new ConvertImgUtil();
        File[] files = new File("d:\\cqgq20181227").listFiles();

        for(File file:files){
            byte[] image = convertImgUtil.convertImg(convertImgUtil.getBytes(file),true);
            //convertImgUtil.getFile(image,"d://","11111.jpg");
            System.out.println("通过"+file.getName()+"生成11111.jpg");
        }
        System.out.println("fdsafdsa");*/
    }
}
