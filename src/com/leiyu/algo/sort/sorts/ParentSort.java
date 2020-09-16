package com.leiyu.algo.sort.sorts;

import java.util.Arrays;

/**
 * 排序方法的父类
 */

public class ParentSort {
    public String getName() {
        return "默认排序";
    }

    public void sort(int[] array) {
        Arrays.sort(array);
    }

    public void exch(int[] array, int lIndex, int rIndex) {
        int m = array[lIndex];
        array[lIndex] = array[rIndex];
        array[rIndex] = m;
    }

}
