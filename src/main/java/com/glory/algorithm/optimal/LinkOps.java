package com.glory.algorithm.optimal;

/**
 * 链表相关操作
 *
 * @author Glory
 * @create 2020-03-23 11:28
 **/
public class LinkOps {

    private Node head;
    private Node tail;

    public LinkOps(Node head) {
        this.head = head;
        this.tail = head;
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
            this.prev = null;
            this.next = null;
        }
    }

    private void add(Node node) {
        tail.next = node;
        tail = node;
    }

    private void print() {
        Node next = head;
        while (next != null) {
            System.out.print(next.val + " --> ");
            next = next.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkOps link = new LinkOps(new Node(10));
        for (int i = 11; i < 16; i++) {
            link.add(new Node(i));
        }
        link.print();

        LinkOps link2 = new LinkOps(new Node(17));
        link2.add(new Node(18));
        link2.add(new Node(20));
        link2.add(new Node(21));
        link2.add(new Node(22));
        link2.print();

        // 合并
        link.orderMerge(link2.head);
        link.print();
    }

    /**
     * 单来表反转
     */
    public void reversal() {
        if (head == null || head.next == null) return;
        Node next = head.next;
        Node pred = head;
        pred.next = null;
        while (next != null) {
            head = next;
            next = next.next;
            head.next = pred;
            pred = head;
        }
    }

    /**
     * 单链寻找中间节点
     * 思路：回文串比较一样，快慢指针
     */
    public void midNode() {
        Node fast = head;
        Node slow = head;
        Node pred = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pred = slow;
            slow = slow.next;
        }
        // 奇数
        if (fast == null) {
            System.out.println("mid=" + pred.val + "," + slow.val);
        } else {
            System.out.println("mid=" + slow.val);
        }
    }

    public void orderMerge(Node link) {
        Node p1 = head;
        Node p2 = link;

        Node pred1 = null;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                if (p1.next == null) {
                    p1.next = p2;
                    break;
                } else {
                    pred1 = p1;
                    p1 = p1.next;
                }
            }
            // case2：p1.val >= p2.val
            else {
                Node next = p2.next;
                if (pred1 == null) {
                    head = p2;
                    head.next = p1;
                    pred1 = head;
                } else {
                    pred1.next = p2;
                    pred1 = pred1.next;
                    p2.next = p1;
                }
                p2 = next;
            }
        }
    }
}
