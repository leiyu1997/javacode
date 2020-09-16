package com.leiyu.algo.sort.sorts;

/**
 * 选择排序
 * <p>
 * 选择排序最核心的概念就是选择剩下元素中的最小者，并与当前位置的值交换
 * 时间复杂度 O(n^2)
 */

public class Selection extends ParentSort {
    @Override
    public void sort(int[] array) {
        for (int i = 0, min; i < array.length; i++) {
            min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            exch(array, min, i);
        }
    }

    @Override
    public String getName() {
        return "选择排序";
    }
}
