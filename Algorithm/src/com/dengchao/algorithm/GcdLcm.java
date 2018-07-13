package com.dengchao.algorithm;
//最大公约数、最小公倍数
public class GcdLcm {

    public static void main(String[] args) {
        System.out.println(gcd(4, 8));
        System.out.println(lcm(4,8));
    }

    public static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        } else {
            return gcd(b, r);
        }
    }
    
    public static int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }

}
