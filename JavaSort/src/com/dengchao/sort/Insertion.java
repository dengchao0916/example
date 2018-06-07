package com.dengchao.sort;

/**
 *@Title:Insertion
 *@Description:特点：效率低，容易实现。 
                          思想：将数组分为两部分，将后部分元素逐一与前部分元素比较，
                          如果当前元素array[i]小，就替换。找到合理位置插入array[i]
 *@author dengchao
 */
public class Insertion {
    public void insertionSort(int array[]) {
        int i, j, t = 0;
        for (i = 1; i < array.length; i++) {
            t = array[i];
            for (j = i - 1; j >= 0 && t < array[j]; j--)
                array[j + 1] = array[j];
                array[j + 1] = t;
        }
    }
}
