package com.pspot.wicket.page.home;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/22
 */
public class HomePage extends WebPage{

    public  HomePage(){

        add(new Label("startMessage","Start Success!"));
    }
}
