package com.dengchao.util;

import java.io.File;

public class TestPath {
    public static void main(String[] args) throws Exception {
        // 如果不加“/” 采用“” 获取当前类的加载目录
        String path = TestPath.class.getResource("").getPath();
        System.out.println("当前类的加载目录:" + path);
        // 加“/”获取类加载的根路径
        String path2 = TestPath.class.getResource("/").getPath();
        System.out.println("类加载的根路径:" + path2);
        // 项目根路径
        String path3 = new File("").getCanonicalPath();
        System.out.println("项目根路径:" + path3);
        // 获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
