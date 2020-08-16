package com.glory.algorithm.optimal;

import java.util.Scanner;

/**
 * 单向链表回文串判断
 *
 * @author Glory
 * @create 2020-03-23 9:21
 **/
public class SinglyLinkPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        Node head = null;
        Node cur = null;
        for (int i = 0; i < len; i++) {
          Node node = new Node(scanner.nextInt());
          if (head == null) {
              head = node;
              cur = head;
          } else {
              cur.next = node;
              cur = cur.next;
          }
        }

        System.out.println("是否为回文串: " + isPalindrome(head));
    }

    private static  boolean isPalindrome(Node head) {
        // null、一个节点情况
        if (head == null || head.next == null) {
            return true;
        }

        Node prev = head;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            // 快指针步长 = 2
            fast = fast.next.next;
            // 慢指针步长 = 1
            // slow = slow.next;
            // 反转链表方向
            Node next = slow.next;
            if (slow == prev) {
                prev.next = null;
            } else {
                slow.next = prev;
            }
            prev = slow;
            slow = next;
        }

        // 链表长度为偶数情况，slow指针需要往前一步，保持左右长度一致
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    private static class Node {
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
}
