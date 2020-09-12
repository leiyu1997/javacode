package com.leiyu.algo.sort.utils;

import java.util.Random;

public class ArrayUtils {

    public static int[] getArray(int length){
        int[] array=new int[length];
        Random random=new Random();
        for (int i = 0; i < length; i++) {
            array[i]= random.nextInt(length*5);
        }
        return array;
    }

    public static boolean isSort(int[] array) {
        if (array.length == 0) {
            return false;
        } else if (array.length <= 2) {
            return true;
        } else {
            boolean lt = array[0] <= array[1];
            boolean rt = array[0] >= array[1];
            for (int i = 2; i < array.length; i++) {
                lt &= array[i - 1] <= array[i];
                rt &= array[i - 1] >= array[i];
            }
            return lt || rt;
        }
    }
}
