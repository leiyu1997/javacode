package com.leiyu.algo.sort.sorts;

/**
 * @program: javacode
 * @description: 快速排序
 * @author: yuleif
 * @create: 2020-09-17 20:42
 **/
public class Quick extends ParentSort {

    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = array[l];
            while (i < j) {
                while (i < j && array[j] > x) {
                    j--;
                }
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }

                while (i < j && array[i] < x) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = x;
            quickSort(array, l, i - 1);
            quickSort(array, i + 1, r);
        }
    }
}
