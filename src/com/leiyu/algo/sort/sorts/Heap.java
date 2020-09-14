package com.leiyu.algo.sort.sorts;

import java.util.Arrays;

/**
 * 堆排序
 */
public class Heap extends ParentSort {
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length ; i++) {
            sink(array, i);
        }
    }

    private void sink(int[] array, int k) {
        int l = 2 * k;
        int r = 2 * k + 1;
        if (r < array.length && array[l] < array[r]) l++;
        if (l < array.length && array[k] < array[l]) {
            exch(array, k, l);
            sink(array, l);
        }
    }
}
