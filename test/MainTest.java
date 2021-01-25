import com.leiyu.algo.node.Node;
import com.leiyu.algo.node.factory.LinkedFactory;
import com.leiyu.algo.node.util.LinkedUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @program: javacode
 * @description: 普通测试类
 * @author: yulei
 **/
public class MainTest {

    @Test
    public void test() {
        int a=0b1111;
        System.out.println(Integer.toBinaryString(a>>>16));
    }

    public void sink(int[] array,int k,int n){
        int l=2*k+1;
        int r=l+1;
        if(r<n&&array[r]>array[l])l++;
        if(l<n&&array[l]>array[k]){
            exch(array,l,k);
            sink(array,l,n);
        }
    }

    public void exch(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

}

//事务失效spring
//索引失效 mysql

