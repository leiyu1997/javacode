package algo;

import com.leiyu.algo.sort.utils.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 排序算法测试类
 */
public class SortTest {

    int[] array;
    long beginTime;

    @Test
    public void sort() {

    }

    @Before
    public void before() {
        array = ArrayUtils.getArray(1000);
        beginTime = System.currentTimeMillis();
    }

    @After
    public void after() {
        long time = System.currentTimeMillis() - beginTime;
//        System.out.println(pSort.getName() + "results:" + Arrays.toString(array));
        System.out.println(String.format("isSuccess:%b,\ttime(ms): %d", ArrayUtils.isSort(array), time));
    }
}
