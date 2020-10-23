package com.leiyu.algo.node.util;

import com.leiyu.algo.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javacode
 * @description: 链表工具类
 * @author: yuleif
 * @create: 2020-10-23 17:01
 **/
public class LinkedUtils {

    public static List<Integer> printLinkedNode(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list.toString());
        return list;
    }
}
