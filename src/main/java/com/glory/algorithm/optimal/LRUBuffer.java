package com.glory.algorithm.optimal;

import java.util.Scanner;

/**
 * LRU双向链表
 *
 * @author Glory
 * @create 2020-03-23 10:18
 **/
public class LRUBuffer {

    /**
     * buffer容量
     */
    private int capacity;

    /**
     * 可用容量
     */
    private int available;

    /**
     * 链表头指针
     */
    private Node head;

    /**
     * 链表尾指针
     */
    private Node tail;

    public LRUBuffer(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
    }

    public LRUBuffer add(Node node) {
        // 容量为0，删除末尾节点
        if (available == 0) {
            removeTail();
        }
        if (head == null) {
            head = node;
            head.next = head;
            tail = head;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        available--;
        System.out.println("可用容量=" + available);
        return this;
    }

    private void removeTail() {
        System.out.println("容量超标，清除末尾节点");
        tail = tail.prev;
        tail.next = null;
        available++;
    }

    public int available() {
        return available;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capcity = scanner.nextInt();
        LRUBuffer lruBuffer = new LRUBuffer(capcity);
        System.out.println("初始化容量=" + capcity);
        int val;
        while ((val = scanner.nextInt()) > 0) {
            lruBuffer.add(new Node(val));
        }
    }

    /**
     * 链表节点结构
     */
    private static class Node {
        Node prev;
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
}
