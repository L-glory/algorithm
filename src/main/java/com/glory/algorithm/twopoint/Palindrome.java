package com.glory.algorithm.twopoint;

/**
 * 回文串判断
 *
 * @author Glory
 * @create 2020-08-16 17:28
 **/
public class Palindrome {

    private static class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
    }


    private static void print(Node node) {

        while (node != null && node.next != null) {
            System.out.print(node.val + " --> ");
            node = node.next;
        }
        System.out.println(node.val);
    }

    /**
     * 串有两种形式：数组，链表
     */
    public static class LinkParlindrome {
        // 链表左边
        private Node left;
        private Node head;

        public LinkParlindrome(Node head) {
            this.head = head;
            this.left = head;
        }

        public boolean isParlindorme() {
            if (head == null) return false;
            if (head.next == null) return true;

            return traverse(head);
        }
        private boolean traverse(Node right) {
            if (right == null) return true;
            boolean res = traverse(right.next) && (left.val == right.val);
            left = left.next;
            return res;
        }
    }

    public static boolean isParlindorme1(Node root) {
        if (root == null) return false;
        if (root.next == null) return true;

        // step1：找到链表重点
        Node slow = root;
        Node fast = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node = head;
        for (int i = 1; i < 6; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        for (int i = 5; i >= 0; i--) {
            node.next = new Node(i);
            node = node.next;
        }
        print(head);
        LinkParlindrome parlindrome = new LinkParlindrome(head);
        System.out.println(parlindrome.isParlindorme());
    }

}
