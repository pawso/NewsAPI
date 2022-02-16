package com.example.newsapi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

public class URLCreator {

    static final String charset = java.nio.charset.StandardCharsets.UTF_8.name();

    Properties appProperties;

    URLCreator(Properties appProperties) {
        this.appProperties = appProperties;
    }

    public String getQuery() throws RuntimeException {
        try {
            String query = String.format("category=%s&country=%s&apiKey=%s",
                    URLEncoder.encode(appProperties.getProperty("url.category"), charset),
                    URLEncoder.encode(appProperties.getProperty("url.language"), charset),
                    URLEncoder.encode(appProperties.getProperty("url.apikey"), charset));

            return appProperties.getProperty("url.endpoint") + "?" + query;
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error while creating query: " + ex.getMessage());
            throw new RuntimeException("Error creating query");
        }
    }
}
