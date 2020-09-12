package com.leiyu.algo.sort.sorts;

/**
 * 排序方法的父类
 */

public class ParentSort {

    public void sort(int[] array) {
    }

    public void exch(int[] array, int lIndex, int rIndex) {
        int m = array[lIndex];
        array[lIndex] = array[rIndex];
        array[rIndex] = m;
    }

}
