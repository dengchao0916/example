package com.dengchao.sort;

public class Test {

    public static void bubble(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertion(int[] array) {
        int temp, i, j;
        for (i = 1; i < array.length; i++) {
            temp = array[i];
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public static void select(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int flag = i;
            int temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (temp > array[j]) {
                    temp = array[j];
                    flag = j;
                }
                if (flag != i) {
                    array[flag] = array[i];
                    array[i] = temp;
                }

            }

        }
    }

    public static void main(String[] args) {
        int[] numbers = { 4, 3, 2, 1 };
        select(numbers);
        print(numbers);
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
    }
}
