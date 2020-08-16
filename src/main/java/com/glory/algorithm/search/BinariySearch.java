package com.glory.algorithm.search;

/**
 * 二分查找
 *
 * @author Glory
 * @create 2020-03-26 9:50
 **/
public class BinariySearch {

    /**
     * 有序数组二分查找
     * @param arr
     * @param k
     * @return
     */
    public static int search(int[] arr, int k) {
        int start = 0;
        int end   = arr.length - 1;

        while (start <= end) {
            // 取中间值，防止位溢出
            int mid = start + ((end - start) >> 1);
            if (arr[mid] == k) {
                if (mid == end || arr[mid + 1] != k) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找递归版本
     * @param arr
     * @param start
     * @param end
     * @param k
     * @return
     */
    public static int search(int[] arr, int start, int end, int k) {
        // 递归终止条件
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (arr[mid] > k) {
            return search(arr, start, end - 1, k);
        } else if (arr[mid] < k) {
            return search(arr, start + 1, end, k);
        } else {
            if (mid == end || arr[mid + 1] != k) {
                return mid;
            } else {
                return search(arr, mid + 1, end, k);
            }
        }
    }

    /**
     * 寻找大于等于K
     * @param arr
     * @param k
     * @return
     */
    public static int searchLt(int[] arr, int k) {
        int start = 0;
        int end   = arr.length - 1;

        // 查找最后一个<=k的数值位置
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] <= k) {
                if (mid == end || arr[mid + 1] > k) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 循环无重复有序数组等值查找
     * @param arr
     * @param k
     * @return
     */
    public static int ringSearch(int[] arr, int k) {
        int start = 0;
        int end   = arr.length - 1;

        /**
         * 1、sorted ringBuffer, 从中间分开，一半是sorted ringBuffer，一半是sorted array
         */
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] == k) {
                return mid;
            }
            // case1: 前半部分有序
            else if (arr[start] < mid) {
                if (arr[mid] > k) {
                    return search(arr, start, mid - 1, k);
                } else {
                    start = mid + 1;
                }
            }
            // case2: 后半部分有序   arr[start] > mid
            else {
                if (arr[mid] > k) {
                    return search(arr, mid + 1, end, k);
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 2);
       /* Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        System.out.println("数组长度=" + len);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(searchLt(arr,5));*/
    }
}
