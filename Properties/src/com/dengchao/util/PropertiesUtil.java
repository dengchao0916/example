package com.dengchao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {
    public static void parseByResourceBundle(String filename) {
        ResourceBundle resources = ResourceBundle.getBundle(filename);
        String username = resources.getString("username");
        String index = resources.getString("index");
        System.out.println(username + "," + index);

    }

    public static void parseByPropertiesLoaderUtils(String filename) throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties(filename);
        String username = properties.getProperty("username");
        String index = properties.getProperty("index");
        System.out.println(username + "," + index);

    }

    public static void parseByClassLoder(String filename) throws IOException {
        Properties properties = new Properties();
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(filename);
        properties.load(in);
        String username = properties.getProperty("username");
        String index = properties.getProperty("index");
        System.out.println(username + "," + index);

    }
}
