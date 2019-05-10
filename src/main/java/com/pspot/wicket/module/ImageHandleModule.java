package com.pspot.wicket.module;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.pspot.wicket.internal.ConvertImgServiceImpl;

/**
 * Created by Administrator on 2019/5/9.
 */
public class ImageHandleModule extends AbstractModule {
    public void configure(){
        final Binder binder = binder();
        binder.bind(ConvertImgServiceImpl.class);
    }
}
