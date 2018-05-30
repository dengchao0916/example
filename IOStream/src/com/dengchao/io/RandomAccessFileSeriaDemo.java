package com.dengchao.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileSeriaDemo {

    public static void main(String[] args) throws IOException {
        File demo = new File("demo");
        if (!demo.exists()) {
            demo.mkdir();
            File file = new File(demo, "just.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            int i = 123;
            /*raf.write(i >>> 24);
            raf.write(i >>> 16);
            raf.write(i >>> 8);*/
            raf.write(i);
            System.out.println(raf.getFilePointer());
            raf.seek(0);
            byte[] buf = new byte[(int) raf.length()];
            raf.read(buf);
            System.out.println(Arrays.toString(buf));
            for (byte b : buf) {
                System.out.print(Integer.toString(b));
            }

        }
    }
}
