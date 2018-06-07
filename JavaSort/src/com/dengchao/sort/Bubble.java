package com.dengchao.sort;

/**
 *@Title:Bubble
 *@Description:特点：效率低，实现简单 
 *                        思想（从小到大排）：每一趟将待排序序列中最大元素移到最后，
 *                        剩下的为新的待排序序列，重复上述步骤直到排完所有元素。
 *                        这只是冒泡排序的一种，当然也可以从后往前排。
 *@author dengchao
 */
public class Bubble {

    public void bubbleSort(int array[]) {
        int t = 0;
        //外循环，需要循环的次数
        for (int i = 0; i < array.length - 1; i++)
            //内循环，每次循环都能确定一个最大的数字让他沉到最底下
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j] > array[j + 1]) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
    }
}
