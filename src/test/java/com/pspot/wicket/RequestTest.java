package com.pspot.wicket;

import com.gfs.finger.util.ConvertImgUtil;
import com.gfs.finger.util.KryoUtils;
import com.pspot.wicket.vo.ImageObject;
import org.junit.Test;

import java.io.File;

public class RequestTest {

    @Test
    public void test1() throws Exception{
        /*ConvertImgUtil convertImgUtil = new ConvertImgUtil();
        byte[] bytes = convertImgUtil.getBytes(new File("d:\\cqgq20181227\\WechatIMG256.jpeg"));
        ImageObject imageObject = new ImageObject();
        imageObject.setImg(bytes);
        KryoUtils kryoUtils = new KryoUtils();
        byte[] imgData = WebHttpClientUtils.call("http://192.168.1.159:8080", kryoUtils.writeImageObject(imageObject));
        convertImgUtil.getFile(kryoUtils.readImgData(imgData),"D:\\Desktop","44.dat");*/
    }

}
