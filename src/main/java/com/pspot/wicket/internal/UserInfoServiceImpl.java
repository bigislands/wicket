package com.pspot.wicket.internal;

import com.pspot.wicket.service.UserInfoService;

import javax.inject.Singleton;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/29
 */
@Singleton
public class UserInfoServiceImpl implements UserInfoService{
    @Override
    public String getUserInfo() {
        return "yuchen";
    }
}
