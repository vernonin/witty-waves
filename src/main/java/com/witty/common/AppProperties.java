package com.witty.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String name;
    private Reecho reecho;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reecho getReecho() {
        return reecho;
    }
    public void setReecho(Reecho reeche) {
        this.reecho = reeche;
    }

    public static class Reecho {
        private String token;
        private String generateUrl;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getGenerateUrl() {
            return generateUrl;
        }

        public void setGenerateUrl(String generateUrl) {
            this.generateUrl = generateUrl;
        }
    }
}
