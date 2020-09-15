package com.leiyu.algo.sort.sorts;

import java.util.Arrays;

/**
 * 堆排序
 */
public class Heap extends ParentSort {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        build(array, n);
        for (; n > 1; n--) {
            exch(array, 0, n - 1);
            sink(array, 0, n - 1);
        }
    }

    private void build(int[] array, int n) {
        for (int i = 0; i <= (n - 1) / 2; i++) {
            sink(array, i, n);
        }
    }

    private void sink(int[] array, int k, int n) {
        int l = 2 * k + 1;
        int r = 2 * k + 2;
        if (r < n && array[r] > array[l]) l++;
        if (l < n && array[l] > array[k]) {
            exch(array, k, l);
            sink(array, Math.max((k - 1) / 2, 0), n);
        }
    }
}
