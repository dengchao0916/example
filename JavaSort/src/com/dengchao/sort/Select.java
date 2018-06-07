package com.dengchao.sort;

/**
 * @Title:Select
 * @Description:特点：效率低，容易实现。 
 *                         思想：每一趟从待排序序列选择一个最小的元素放到已排好序序列的首位，
 *                         剩下的为待排序序列，重复上述步骤直到完成排序。
 * @author dengchao 4 3 2 1
 */
public class Select {
    public static void selectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int flag = i; // 将当前下标定义为最小值下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < temp) {// array[j] < temp 从小到大排序；array[j] > temp 从大到小排序
                    temp = array[j];
                    flag = j; // 如果有小于当前最小值的关键字将此关键字的下标赋值给flag
                }
            }
            if (flag != i) {
                array[flag] = array[i];
                array[i] = temp;
            }
        }
    }
}
