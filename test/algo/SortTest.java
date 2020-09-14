package algo;

import com.leiyu.algo.sort.sorts.*;
import com.leiyu.algo.sort.utils.ArrayUtils;
import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

/**
 * 排序算法测试类
 */
public class SortTest {

    private ParentSort pSort;

    @Test
    public void selectionTest() {
        //选择排序测试
        pSort = new Selection();
    }

    @Test
    public void insertionTest() {
        //插入排序测试
        pSort = new Insertion();
    }

    @Test
    public void BubbleTest() {
        //冒泡排序
        pSort = new Bubble();
    }

    @Test
    public void HeapTest() {
        pSort = new Heap();
    }


    @After
    public void after() {
        int length = 20;
        int[] array = ArrayUtils.getArray(length);
        long beginTime = System.currentTimeMillis();
        pSort.sort(array);
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("结果：" + Arrays.toString(array));
        System.out.println("排序是否成功：" + ArrayUtils.isSort(array));
        System.out.println("排序消耗时间：" + time + "ms");
    }
}
