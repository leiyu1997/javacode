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
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int m = l, n = r, x = array[l];
            while (m < n) {
                while (array[n] > x) {
                    n--;
                }
                if (m < n) {
                    array[m] = array[n];
                    m++;
                }

                while (array[m] < x) {
                    m++;
                }
                if (m < n) {
                    array[n] = array[m];
                    n--;
                }
            }
            array[m] = x;
            quickSort(array, l, m - 1);
            quickSort(array, m + 1, r);
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
