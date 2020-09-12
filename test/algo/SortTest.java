package algo;

import com.leiyu.algo.sort.sorts.Bubble;
import com.leiyu.algo.sort.sorts.Insertion;
import com.leiyu.algo.sort.sorts.ParentSort;
import com.leiyu.algo.sort.sorts.Selection;
import com.leiyu.algo.sort.utils.ArrayUtils;
import org.junit.After;
import org.junit.Test;

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
    public void BubbleTest(){
        //冒泡排序
        pSort=new Bubble();
    }

    @After
    public void afterTest() {
        int length = 10000;
        int[] array = ArrayUtils.getArray(length);
        long beginTime = System.currentTimeMillis();
        pSort.sort(array);
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("排序是否成功：" + ArrayUtils.isSort(array));
        System.out.println("排序消耗时间：" + time + "ms");
    }
}
