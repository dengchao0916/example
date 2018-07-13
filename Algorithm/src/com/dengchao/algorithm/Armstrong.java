package com.dengchao.algorithm;

//1^3 + 5^3 + 3^3 = 153
public class Armstrong {
    public static void main(String[] args) {
        System.out.println("寻找Armstrong数：");
        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = (i % 100) / 10;
            int c = i % 10;
            if (a * a * a + b * b * b + c * c * c == i)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}
