package com.pspot.wicket;

import com.gfs.finger.util.JniLoader;
import com.google.inject.Injector;
import com.pspot.wicket.config.Config;
import com.pspot.wicket.server.JettyServerCreator;
import com.pspot.wicket.support.LoggerConfigurationSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXB;
import java.io.File;
import java.util.Optional;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/24
 */
public class App extends JettyServerCreator {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static  Optional<Injector>  GUICE = Optional.empty();

    public static void main(String[] args){
        try{
            String serverHome = System.getProperty("server.home","support");
            System.setProperty("server.home",serverHome);
            JniLoader jniLoader = new JniLoader();
            jniLoader.loadJniLibrary(serverHome);
            Config config = JAXB.unmarshal(serverHome + File.separator+ "config" + File.separator + "config.xml", Config.class);
            LoggerConfigurationSupport loggerConfigurationSupport = new LoggerConfigurationSupport();
            loggerConfigurationSupport.configLogger(config.getLogFile(),"wicket","app","wicket.app");
            start(config.getWebConfig());
            logger.info("start success");
            join();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
