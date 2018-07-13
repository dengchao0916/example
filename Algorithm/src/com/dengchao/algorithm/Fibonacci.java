package com.dengchao.algorithm;
//1、1 、2、3、5、8、13、21、34、55、89......
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return -1;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
}
