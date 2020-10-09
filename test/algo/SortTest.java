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
        quick(array, 0, array.length - 1);
    }

    void quick(int[] array, int l, int r) {
        if (l < r && r < array.length) {
            int i = l, j = r, x = array[i];
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
            quick(array, l, i - 1);
            quick(array, i + 1, r);
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
