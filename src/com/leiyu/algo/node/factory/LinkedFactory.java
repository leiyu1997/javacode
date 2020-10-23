package com.leiyu.algo.node.factory;

import com.leiyu.algo.node.Node;

import java.util.Random;

public class LinkedFactory {

    public static Node createNodeList(int length) {
        Random random = new Random();
        Node head = new Node(random.nextInt(length * 5));
        Node pre = head;
        for (int i = 1; i < length; i++) {
            pre.next = new Node(random.nextInt(length * 5));
            pre = pre.next;
        }
        return head;
    }
}
