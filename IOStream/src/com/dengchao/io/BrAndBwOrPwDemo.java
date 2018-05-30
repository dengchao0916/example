package com.dengchao.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.imageio.stream.FileImageInputStream;

public class BrAndBwOrPwDemo {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\demo\\just.txt")));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
        // FileOutputStream("E:\\demo\\just1.txt")));
        PrintWriter pw = new PrintWriter("E:\\demo\\just2.txt");
        String line;
        while ((line = br.readLine()) != null) {
            /*
             * bw.write(line); bw.newLine(); bw.flush();
             */
            pw.println(line);
            pw.flush();

        }
        br.close();
        // bw.close();
        pw.close();
    }

}
