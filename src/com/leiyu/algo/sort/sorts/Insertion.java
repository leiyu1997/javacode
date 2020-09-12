package com.leiyu.algo.sort.sorts;

/**
 * 插入排序
 * O（n^2）
 */
public class Insertion extends ParentSort {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                exch(array, j - 1, j);
            }
        }
    }
}
