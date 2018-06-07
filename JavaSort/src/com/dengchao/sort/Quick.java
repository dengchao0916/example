package com.dengchao.sort;

/**
 *@Title:Quick
 *@Description:特点：高效，时间复杂度为nlogn。 
                          采用分治法的思想：首先设置一个轴值pivot，然后以这个轴值为划分基准将
                          待排序序列分成比pivot大和比pivot小的两部分，
                          接下来对划分完的子序列进行快排直到子序列为一个元素为止。
 *@author dengchao
 */
public class Quick {
    public static void quickSort(int array[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = array[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && array[j] >= index)
                j--;
            if (i < j)
                array[i++] = array[j];// 用比基准小的记录替换低位记录
            while (i < j && array[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                array[j--] = array[i];
        }
        array[i] = index;// 将基准数值替换回 a[i]
        quickSort(array, low, i - 1); // 对低子表进行递归排序
        quickSort(array, i + 1, hight); // 对高子表进行递归排序
    }
}
