package com.gfs.finger.util;

import org.fusesource.hawtjni.runtime.Library;

import java.io.File;

/**
 * Created by Administrator on 2019/5/9.
 */
public class JniLoader {

    private  static String WICKET_CONVERT_IMG_PATH_KEY = "library.java_convertImg_cq64.path";
    private  Library IMAGE_LIBRARY = new Library("java_convertImg_cq64",getClass());

    public void loadJniLibrary(String serverHome){
        File file = new File(serverHome);
        String path = System.getProperty(WICKET_CONVERT_IMG_PATH_KEY);
        if(path == null){
            System.setProperty(WICKET_CONVERT_IMG_PATH_KEY,file.getAbsolutePath()+ File.separator + "dll");
        }
        IMAGE_LIBRARY.load();
    }
}
