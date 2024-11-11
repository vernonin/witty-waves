package com.witty;

import com.witty.common.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class WittyWavesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WittyWavesApplication.class, args);
    }

}
