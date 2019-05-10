package com.pspot.wicket.internal;

import com.gfs.finger.util.ConvertImgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liukai on 2019/5/6.
 */
public class ConvertImgServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ConvertImgServiceImpl.class);

    public byte[] convertImage(byte[] img,boolean flag){
        byte[] result = null;
        try{
            result = ConvertImgUtil.convertImg(img, true);
        }catch (Exception e){
            logger.error("处理图像失败{}",e.getMessage());
        }
        return result;
    }
}
