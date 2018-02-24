package com.zmx.util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Configuration
//@EnableAutoConfiguration
@PropertySource(value = "classpath:config.yml")
@Component
@ConfigurationProperties(prefix="test")


public class MyConfig {
    @Value("${name}")
     public String name;

}
