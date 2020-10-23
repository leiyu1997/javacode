package algo;

import com.leiyu.algo.sort.sorts.Quick;
import com.leiyu.algo.sort.utils.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 排序算法测试类
 */
public class SortTest {

    int[] array;
    long beginTime;

    @Test
    public void sort() {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            sink(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            sink(array, 0, i);
        }
    }

    public void sink(int[] array, int k, int n) {
        int l = 2 * k + 1;
        int r = 2 * k + 2;
        if (r < n && array[r] > array[l]) l++;
        if (l < n && array[l] > array[k]) {
            int temp = array[k];
            array[k] = array[l];
            array[l] = temp;
            sink(array, l, n);
        }
    }


    @Before
    public void before() {
        array = ArrayUtils.getArray(10000);
        beginTime = System.currentTimeMillis();
    }

    @After
    public void after() {
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("results:" + Arrays.toString(array));
        System.out.println(String.format("isSuccess:%b,\ttime(ms): %d", ArrayUtils.isSort(array), time));
    }
}
