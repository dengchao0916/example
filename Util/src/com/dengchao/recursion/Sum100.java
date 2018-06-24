package com.dengchao.recursion;

public class Sum100 {

    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static int sum(int n) {

        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
