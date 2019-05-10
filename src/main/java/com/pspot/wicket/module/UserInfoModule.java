package com.pspot.wicket.module;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.pspot.wicket.filter.RequestFilter;
import com.pspot.wicket.internal.UserInfoServiceImpl;
import com.pspot.wicket.service.UserInfoService;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/29
 */
public class UserInfoModule extends AbstractModule {

    public void configure(){
        final Binder binder = binder();
        binder.bind(UserInfoService.class).to(UserInfoServiceImpl.class);
    }
}
