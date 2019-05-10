package com.pspot.wicket.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 2019/5/9.
 */
@XmlRootElement(name = "config")
public class Config {
    private WebConfig webConfig;

    @XmlElement(name = "web_config")
    public WebConfig getWebConfig() {
        return webConfig;
    }

    public void setWebConfig(WebConfig webConfig) {
        this.webConfig = webConfig;
    }
}
