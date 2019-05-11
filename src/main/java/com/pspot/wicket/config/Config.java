package com.pspot.wicket.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 2019/5/9.
 */
@XmlRootElement(name = "config")
public class Config {
    private WebConfig webConfig;

    private String logFile;

    @XmlElement(name = "web_config")
    public WebConfig getWebConfig() {
        return webConfig;
    }

    public void setWebConfig(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @XmlElement(name = "log_file")
    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }
}
