package com.example.newsapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static final String CONFIG_FILE_NAME = "/app.prop";

    static public Properties readConfig() throws RuntimeException {
        Properties properties = new Properties();
        String fileName = CONFIG_FILE_NAME;

        try {
            InputStream fis = ConfigReader.class.getResourceAsStream(CONFIG_FILE_NAME);
            properties.load(fis);
        }  catch (IOException ex) {
            System.out.println("Could not read config file " + fileName + " " + ex.getMessage());
            throw new RuntimeException("ConfigReader failed");
        }
        return properties;
    }
}
