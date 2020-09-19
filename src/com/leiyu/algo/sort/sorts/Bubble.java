package com.leiyu.algo.sort.sorts;

/**
 * 冒泡排序
 * O（n^2）
 */
public class Bubble extends ParentSort {

    @Override
    public void sort(int[] array) {
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    exch(array, j, j + 1);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "冒泡排序";
    }
}
