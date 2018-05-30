package com.dengchao.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

    /**
     * 读取指定文件内容，按照16进制输出到控制台 并且每输出5个byte换行
     * 
     * @param fileName
     *            单字节读取不适合大文件，大文件效率很低
     */
    public static void printHex(String filename) throws Exception {
        FileInputStream in = new FileInputStream(filename);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            System.out.print(Integer.toHexString(b) + "  ");
            if (i++ % 5 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
     * 
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String filename) throws Exception {
        FileInputStream in = new FileInputStream(filename);
        byte[] buf = new byte[1024];
        int bytes = in.read(buf, 0, buf.length);
        int j = 1;
        for (int i = 0; i < bytes; i++) {
            System.out.print(Integer.toHexString(buf[i]) + "  ");
            if (j++ % 5 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 文件拷贝，字节批量读取
     * 
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws Exception {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }

        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }

        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();
        }
        in.close();
        out.close();

    }

    /**
     * 进行文件的拷贝，利用带缓冲的字节流
     * 
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile, File destFile) throws Exception {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int c;
        while ((c = bis.read()) != -1) {
            bos.write(c);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

    public static void copyFileByByte(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);

        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }

}
