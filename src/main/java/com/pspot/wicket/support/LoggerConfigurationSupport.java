package com.pspot.wicket.support;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/5/10
 */
public class LoggerConfigurationSupport {

    public void configLogger(String logFile,String prefix,String... loggerPrefix){
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        Handler[]  handlers = rootLogger.getHandlers();
        for(Handler handler : handlers){
            rootLogger.removeHandler(handler);
        }
        SLF4JBridgeHandler.install();
        System.setProperty("net.spy.log.LoggerImpl","net.spy.memcached.compat.log.SLF4JLogger");
        if (System.getProperty("enable-log") != "true") {
            System.setProperty("log4j.defaultInitOverride", "false");
            Properties properties = new Properties();
            properties.put("log4j.rootCategory", "error,R");
            properties.put("log4j.appender.R", "org.apache.log4j.RollingFileAppender");
            properties.put("log4j.appender.R.layout", "org.apache.log4j.PatternLayout");
            properties.put("log4j.appender.R.layout.ConversionPattern", "[" + prefix + "] %d{MM-dd HH:mm:ss} [%p] %m%n");
            properties.put("log4j.appender.R.File", logFile);
            properties.put("log4j.appender.R.MaxFileSize", "10000KB");
            properties.put("log4j.appender.R.MaxBackupIndex", "10");
            for(String p : loggerPrefix){
                properties.put("log4j.category." + p, "info");
            }
            properties.put("log4j.category.org.apache.zookeeper", "warn");
            properties.put("log4j.category.com.netflix", "warn");

            PropertyConfigurator.configure(properties);
        }
    }
}
