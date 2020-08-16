package com.glory.algorithm.important;

import java.util.Arrays;

/**
 * 数组交换
 *
 * @author Glory
 * @create 2020-08-16 13:31
 **/
public class SwapArray {

    /**
     * 问题描述：
     *     1、数组[1,2,3,4,5,6,7,8,9]，交换k元素,eg: k=3, [7,8,9,1,2,3,4,5,6]
     *
     *
     */

    /**
     * 翻转方案
     * k=3
     *    1、从k位置划分两个数组：[1,2,3,4,5,6]   [7,8,9]
     *    2、翻转两个数组：[6,5,4,3,2,1]  [9,8,7]
     *    3、把翻转后的两个数组，从新组合为一个数组，[6,5,4,3,2,1,9,8,7]
     *    4、把整体数组翻转
     * @param arr
     * @param k
     * @return
     */
    public static int[] rotate(int[] arr, int k) {
        int len = arr.length;
        int bound = len - (k % len) - 1;

        // step1: 翻转第一段
        reverse(arr, 0, bound - 1);
        // step2: 翻转第二段
        reverse(arr, bound, len - 1);
        // step3: 整体翻转
        reverse(arr, 0, len - 1);

        return arr;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 撑杆跳，每个元素往右移动k步，溢出元素返回最左边继续移动；
     *  [1,2,3,4,5,6,7], k=3, 整体右移3步 --> [5,6,7,1,2,3,4]
     * @param arr
     * @param k
     * @return
     */
    public static int[] copy(int[] arr, int k) {
        int len = arr.length;
        int bound = len - (k % len);
        int[] tmp = Arrays.copyOf(arr, len - bound);
        System.arraycopy(arr, bound - 1, arr, 0, bound);
        System.arraycopy(tmp, 0, arr, bound, tmp.length);
        return arr;
    }

}
