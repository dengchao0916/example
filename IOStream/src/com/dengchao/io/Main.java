package com.dengchao.io;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        IOUtil.printHex("E:\\demo\\just.txt");
        System.out.println();
        System.out.println("=============");
        IOUtil.printHexByByteArray("E:\\demo\\just.txt");
        //IOUtil.copyFile(new File("E:\\demo\\just.txt"), new File("E:\\demo\\copy.txt"));
        //IOUtil.copyFileByBuffer(new File("E:\\demo\\just.txt"), new File("E:\\demo\\copy1.txt"));
        IOUtil.copyFileByByte(new File("E:\\demo\\just.txt"), new File("E:\\demo\\copy2.txt"));
    }

}
