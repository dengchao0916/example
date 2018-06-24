package com.dengchao.recursion;

public class Gcd {

    public static void main(String[] args) {
        System.out.println(gcd(4, 8));
    }

    public static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        } else {
            return gcd(b, r);
        }

    }
}
