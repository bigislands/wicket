package com.pspot.wicket.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 2019/5/9.
 */
@XmlRootElement
public class WebConfig {

    private String bind = "127.0.0.1:8080";

    @XmlElement
    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }
}
