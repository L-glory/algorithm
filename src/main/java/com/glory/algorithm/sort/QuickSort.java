package com.glory.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快排
 *
 * @author Glory
 * @create 2020-03-26 8:56
 **/
public class QuickSort {

    /**
     * 经典快排递归实现
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        // 中间数
        //int mid = arr[left + ((right - left) >> 1)];
        // 取开始数、中间数、末尾数的平均值作为衡量
        //int standard = arr[left] / 3 + mid / 3 + arr[right] / 3;

        int start    = left;
        int end      = right;
        int standard = arr[start];

        while (start < end) {
            if (arr[end] >= standard && start < end) {
                end--;
            }
            arr[start] = arr[end];
            if (arr[start] <= standard && start < end) {
                start++;
            }
            arr[end] = arr[start];
        }

        arr[start] = standard;

        sort(arr, left, end - 1);
        sort(arr, start + 1, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        System.out.println("数组长度=" + len);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
