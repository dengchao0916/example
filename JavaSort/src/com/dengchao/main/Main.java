package com.dengchao.main;

import com.dengchao.sort.Insertion;
import com.dengchao.sort.Quick;
import com.dengchao.sort.Select;
import com.dengchao.sort.Shell;

public class Main {

    static int[] numbers = { 23, 54, 234, 654, 342, 536, 6, 32, 4, 45 };

    public static void main(String[] args) {
       /* Bubble bubble = new Bubble();
        bubble.bubbleSort(numbers);
        print(numbers);*/

        /*Select select = new Select();
        Select.selectSort(numbers);
        print(numbers);*/
        
        /*Insertion insertion = new Insertion();
        insertion.insertionSort(numbers);
        print(numbers);*/
        
        Quick.quickSort(numbers, 0, numbers.length-1);
        print(numbers);
        
        /*Shell.shellSort(numbers);
        print(numbers);*/
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
    }
}
