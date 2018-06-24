package com.dengchao.recursion;
/*爬楼梯算法：已知一个楼梯有n个台阶，
 * 每次可以选择迈上一个或者两个台阶，
 * 求走完一共有多少种不同的走法。*/
public class ClimbStairs {

    public static void main(String[] args) {
        int a = climbStairs(3);
        System.out.println(a);
    }

    public static int climbStairs(int n) {
        int i = 1;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            i++;
            return i;

        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

    }

}
