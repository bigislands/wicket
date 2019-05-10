package com.pspot.wicket.server;

import com.google.inject.servlet.GuiceFilter;
import com.pspot.wicket.config.WebConfig;
import com.pspot.wicket.filter.RequestFilter;
import com.pspot.wicket.listener.MyServletRequestListener;
import com.pspot.wicket.page.home.HomePageApplication;
import org.apache.wicket.Application;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.ContextParamWebApplicationFactory;
import org.apache.wicket.protocol.http.WicketFilter;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EventListener;
import java.util.Optional;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/22
 */
public class JettyServerCreator{

    private static Optional<Server> server = Optional.empty();

    private static final String pkg = HomePageApplication.class.getName();
    private static final String appName = "cherish";

    public JettyServerCreator(){
        super();
    }

    public static void start(WebConfig webConfig) throws Exception{
        String[]  config =  webConfig.getBind().split(":");
        server = Optional.of(createWicketWebApp(config[0],Integer.valueOf(config[1])));
        server.get().start();
    }

    public static void join() throws InterruptedException {
        server.get().join();
    }

    private static Server createWicketWebApp(String host,int port){

        Server server = new Server();
        SelectChannelConnector selectChannelConnector = new SelectChannelConnector();
        selectChannelConnector.setHost(host);
        selectChannelConnector.setPort(port);
        Connector[] connectors = new Connector[] {selectChannelConnector};
        server.setConnectors(connectors);
        server.setSendServerVersion(false);

        FilterHolder filterHolder = new FilterHolder(RequestFilter.class);
        filterHolder.setName(appName);
        filterHolder.setInitParameter(ContextParamWebApplicationFactory.APP_CLASS_PARAM,pkg);
        filterHolder.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM,"/*");
        filterHolder.setInitParameter(Application.CONFIGURATION, RuntimeConfigurationType.DEPLOYMENT.toString());

        FilterHolder filterHolderForGuice = new FilterHolder(GuiceFilter.class);
        filterHolderForGuice.setName("guiceFilter");

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        servletContextHandler.setDisplayName(appName);


        servletContextHandler.addFilter(filterHolder
                ,"/*"
                ,java.util.EnumSet.allOf(DispatcherType.class));
        servletContextHandler.addFilter(filterHolderForGuice
                ,"/*"
                ,java.util.EnumSet.allOf(DispatcherType.class));

        servletContextHandler.addServlet(DefaultServlet.class,"/");


        EventListener[] eventListeners = {new MyServletRequestListener()};
        servletContextHandler.setEventListeners(eventListeners);

        server.setHandler(servletContextHandler);
        return server;
    }

}
