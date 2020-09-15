package algo;

import com.leiyu.algo.sort.sorts.*;
import com.leiyu.algo.sort.utils.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 排序算法测试类
 */
public class SortTest {

    ParentSort pSort;
    int[] array;

    @Before
    public void before() {
        int length = 10000;
        array = ArrayUtils.getArray(length);
    }

    @Test//选择排序测试
    public void selectionTest() {
        pSort = new Selection();
    }
    @Test//插入排序测试
    public void insertionTest() {
        pSort = new Insertion();
    }
    @Test//冒泡排序
    public void BubbleTest() {
        pSort = new Bubble();
    }
    @Test
    public void HeapTest() {
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        pSort = new Heap();
    }


    @After
    public void after() {
        long beginTime = System.currentTimeMillis();
        pSort.sort(array);
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("结果：" + Arrays.toString(array));
        System.out.println("排序是否成功：" + ArrayUtils.isSort(array));
        System.out.println("排序消耗时间：" + time + "ms");
    }
}
