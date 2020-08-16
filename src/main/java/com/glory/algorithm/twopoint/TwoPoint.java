package com.glory.algorithm.twopoint;

/**
 * 双指针算法方案
 *
 * @author Glory
 * @create 2020-08-13 21:06
 **/
public class TwoPoint {

    public static class Node {
        int val;
        Node pred;
        Node next;
        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node = head;
        for (int i = 2; i < 10; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        printf(head);
        System.out.println(find(head, 7));
    }

    private static void printf(Node head) {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(" --> ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * 判断链表是够存在换，存在返回环的起点
     * @param head
     * @return
     */
    public static Node hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        // 不存在环 || 环形链表
        if ((fast == null || fast.next == null) || head == fast) {
            return fast;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    /**
     * 寻找链表倒数第K个数
     * @param head
     * @param k
     * @return
     */
    public static Node find(Node head, int k) {
        if (head == null || head.next == null) return head;
        if (k < 1) return head;

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 二分查找
     */
    public static int binarySearch(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) return -1;

        int start = 0;
        int end = len -1;

        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 有序数组，给定一个数K，找出两个元素，相加等于K，返回两元素index
     */
    public static int[] twoSum(int arr[], int target) {
        int len = arr.length;
        if (len < 2) return new int[]{-1, -1};

        int start =  0;
        int end =  len - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                return new int[]{start, end};
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 数组反转
     */
    public static int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return arr;
    }
}
