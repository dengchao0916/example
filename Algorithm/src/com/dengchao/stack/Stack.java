package com.dengchao.stack;

/**
 * 基于数组实现的顺序栈
 * 
 */
public class Stack {
    int[] arr;
    int len = 0;

    public Stack() {
        arr = new int[100];
    }

    public Stack(int n) {
        arr = new int[n];
    }

    public int size() {
        return len + 1;
    }

    // 扩大数组
    public void resize() {
        int[] b = new int[arr.length * 2];
        System.arraycopy(arr, 0, b, 0, arr.length);
        arr = b;
    }

    public void show() {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    // 进栈
    public void push(int a) {
        if (len >= arr.length)
            resize();
        arr[len] = a;
        len++;
    }

    // 出栈
    public int pop() {
        if (len == 0) {
            System.out.println();
            System.out.println("stack is empty!");
            return -1;
        }
        int a = arr[len - 1];
        arr[len - 1] = 0;
        len--;
        return a;
    }
}