package com.glory.algorithm.sort;

import java.util.Scanner;

/**
 * 数组排序
 *
 * @author Glory
 * @create 2020-03-24 17:18
 **/
public class ArraySort {

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }

        for (int i = 1; i < len; i++) {
            int val = arr[i];
            int j = i - 1;

            // 把比val大的值，往后移动一格
            for (; j >= 0; j--) {
                if (arr[j] > val) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }

            // 把val插入移动后的位置
            arr[j+1] = val;
        }

        return arr;
    }

    /**
     * 无序数组查找第k大元素
     * @param arr
     * @return
     */
    public static int partitionSearch(int[] arr, int start, int end, int k) {
        int index = partition(arr, start, end);
        if (index == k - 1) {
            return arr[index];
        } else if (index > k - 1) {
            return partitionSearch(arr, start, index - 1, k);
        } else {
            return partitionSearch(arr, index + 1, end, k - index);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int standard = arr[start];
        // 把大于standard的元素交换到standard的右边
        while (start < end) {
            while (arr[end] <= standard && start < end) {
                end--;
            }
            arr[start] = arr[end];
            while (arr[start] >= standard && start < end) {
                start++;
            }
            arr[end] = arr[start];
        }

        arr[end] = standard;

        return end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        System.out.println("数组长度：len=" + len);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("第3大元素：" + partitionSearch(arr, 0, len - 1, 3));
    }

}
