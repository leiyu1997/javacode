package algo;

import com.leiyu.algo.sort.sorts.*;
import com.leiyu.algo.sort.utils.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void BubbleTest() {
        pSort = new Bubble();
    }

    @Test//堆排序
    public void HeapTest() {
        pSort = new Heap();
    }


    @After
    public void after() {
        long beginTime = System.currentTimeMillis();
        pSort.sort(array);
        long time = System.currentTimeMillis() - beginTime;
//        System.out.println(pSort.getName() + "results:" + Arrays.toString(array));
        System.out.println(String.format("%s\tisSuccess:%b,\ttime(ms): %d", pSort.getName(), ArrayUtils.isSort(array), time));
    }
}
