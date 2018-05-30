package com.dengchao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("e:\\demo\\just.txt");
        InputStreamReader isr = new InputStreamReader(in, "utf-8");
        FileOutputStream out = new FileOutputStream("e:\\demo\\just3.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");

        int c;
        char[] buffer = new char[1024];
        while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
            String s = new String(buffer, 0, c);
            System.out.println(s);
            osw.write(buffer, 0, c);
            osw.flush();

        }
        osw.close();
        isr.close();

    }

}
