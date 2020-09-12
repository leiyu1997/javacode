package com.leiyu.algo.sort.sorts;

/**
 * 冒泡排序
 * O（n^2）
 */
public class Bubble extends ParentSort {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    exch(array, j, j + 1);
                }
            }
        }
    }
}
