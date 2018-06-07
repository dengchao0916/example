package com.dengchao.table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Table {
    // 表的简单数组实现，数据扩容
    public void extendTable() {
        int[] arr = new int[10];
        int[] newarr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        arr = newarr;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        for (Integer temp : list) {
            System.out.print(temp);
        }
        System.out.println("-------------");

        /*
         * java.util.ConcurrentModificationException for (Integer temp : list) {
         * if (temp % 2 == 0) { list.remove(temp); } }
         */

        /*
         * int j = 0; while (j < list.size()) { if (list.get(j) % 2 == 0) {
         * list.remove(j); } else { j++; } }
         */

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }

        List<String> list1 = new LinkedList<String>();

        for (Integer temp : list) {
            System.out.print(temp);
        }

    }
}
