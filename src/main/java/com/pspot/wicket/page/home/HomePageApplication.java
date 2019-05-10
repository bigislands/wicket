package com.pspot.wicket.page.home;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/22
 */
public class HomePageApplication extends WebApplication {

    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init(){
        super.init();
        //getComponentInstantiationListeners().add(new GuiceComponentInjector(this, new UserInfoModule()));
    }

}
