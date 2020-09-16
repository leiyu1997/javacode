package com.leiyu.algo.sort.sorts;

/**
 * 堆排序
 */
public class Heap extends ParentSort {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        //构建大顶堆(由最后的非叶子节点开始向上遍历)
        for (int i = (n - 2) / 2; i >= 0; i--) {
            sink(array, i, n);
        }
        //排序(堆顶与末尾交换)
        for (; n > 0; n--) {
            exch(array, 0, n - 1);
            sink(array, 0, n - 1);
        }
    }

    private void sink(int[] array, int k, int n) {
        int l = 2 * k + 1;
        int r = 2 * k + 2;
        if (r < n && array[r] > array[l]) l++;
        if (l < n && array[l] > array[k]) {
            exch(array, k, l);
            sink(array, l, n);
        }
    }

    @Override
    public String getName() {
        return "堆排序";
    }
}
