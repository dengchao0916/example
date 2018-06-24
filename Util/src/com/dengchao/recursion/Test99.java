package com.dengchao.recursion;

public class Test99 {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i * j + "  ");
            }
            System.out.println();
        }
        System.out.println("---------------");
        m(9);
    }

    public static void m(int n) {
        if (n == 1) {
            System.out.println(1);
        } else {
            m(n - 1);
            for (int i = 1; i <= n; i++) {
                System.out.print(i * n + "  ");
            }
            System.out.println();
            
        }
    }
}
