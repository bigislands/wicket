package com.pspot.wicket.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.pspot.wicket.App;
import com.pspot.wicket.module.ImageHandleModule;

import java.util.Optional;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/28
 */
public class MyServletRequestListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        Injector injector = Guice.createInjector(new ImageHandleModule());
        App.GUICE = Optional.of(injector);
        return injector;
    }
}
