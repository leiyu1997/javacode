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
        int length = 100;
        array = ArrayUtils.getArray(length);
    }

    @Test//默认排序
    public void parentSortTest() {
        pSort = new ParentSort();
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
    public void bubbleTest() {
        pSort = new Bubble();
    }

    @Test//堆排序
    public void heapTest() {
        pSort = new Heap();
    }

    @Test
    public void quickTest() {
        pSort = new Quick();
    }

    @After
    public void after() {
        long beginTime = System.currentTimeMillis();
        pSort.sort(array);
        long time = System.currentTimeMillis() - beginTime;
        System.out.println(pSort.getName() + "results:" + Arrays.toString(array));
        System.out.println(String.format("%s\tisSuccess:%b,\ttime(ms): %d", pSort.getName(), ArrayUtils.isSort(array), time));
    }
}
