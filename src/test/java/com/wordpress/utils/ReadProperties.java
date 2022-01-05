package com.wordpress.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private final Properties prop;

    public ReadProperties(String configPath) {
        prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configPath);

        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + configPath + "' not found in the classpath");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
}
