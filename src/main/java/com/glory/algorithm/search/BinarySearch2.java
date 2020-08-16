package com.glory.algorithm.search;

/**
 *
 * 有序数组，二分查找优化版本
 *
 * @author Glory
 * @create 2020-08-14 21:24
 **/
public class BinarySearch2 {


    /**
     * 有序数组查询指定值的index，如果查找值不存在返回-1
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) return -1;

        int start = 0;
        int end = len -1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 在arr数组中，搜索target的左边界
     * @param arr
     * @param target
     * @return
     */
    public static int leftBound(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) return -1;

        int left = 0;
        int right = len;

        // 查询区间[left, right)
        // 结束条件 left == right
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < target) {
                left = mid + 1;   // 查询区间[left, right)
            } else { // arr[mid] >= target，右边收缩
                right = mid;      // 查询区间[left, right)
            }
        }

        // left == right
        return left;               // 存在left个小于等于
    }

    public static int rightBound(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) return -1;

        int left = 0;
        int right = len;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // left == right
        return left - 1;
    }

}
