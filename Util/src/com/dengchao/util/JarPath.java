package com.dengchao.util;

import java.io.File;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarPath {
    public static void main(String[] args) throws Exception {  
        // 项目中jar包所在物理路径  E:\Eclipse\Util\lib\commons-logging-1.1.3.jar
        String jarName = new File("").getCanonicalPath() + "/lib/commons-logging-1.1.3.jar";  
        JarFile jarFile = new JarFile(jarName);  
        Enumeration<JarEntry> entrys = jarFile.entries();  
        while (entrys.hasMoreElements()) {  
            JarEntry jarEntry = entrys.nextElement();  
            System.out.println(jarEntry.getName());  
        }                 
    }  
}
