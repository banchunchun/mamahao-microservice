package com.mamahao.microservice.app.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created with springbootweb -> me.j360.springboot.simple.bean.config.
 * User: min_xu
 * Date: 2015/7/29
 * Time: 13:50
 * 说明：另一种配置方法
 */

@RefreshScope
@Component
@Configuration
@ConfigurationProperties
public class ConfigurationPropertiesConfig {
    private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
