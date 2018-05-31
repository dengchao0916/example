package com.dengchao.main;

import java.io.IOException;

import com.dengchao.util.PropertiesUtil;

public class Main {

    public static void main(String[] args) throws IOException {
        PropertiesUtil.parseByResourceBundle("configs/config");
        PropertiesUtil.parseByPropertiesLoaderUtils("configs/config.properties");
        PropertiesUtil.parseByClassLoder("configs/config.properties");
    }

}
