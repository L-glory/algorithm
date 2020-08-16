package com.glory.algorithm.sort;

/**
 * 堆排序
 *
 * @author Glory
 * @create 2020-04-03 15:07
 **/
public class HeapSort {

    private int capacity;

    private int count;

    private int[] head;

    public HeapSort(int capacity) {
        this.capacity = capacity;
        this.count    = 0;
        this.head     = new int[capacity];
    }

    /**
     * 往排序堆添加元素
     * @param val
     * @return
     */
    public boolean insert(int val) {
        if (count >= capacity) {
            return false;
        }

        // step1: 把元素放入数组末尾
        head[++count] = val;

        // 自低向上堆化
        return false;
    }
}
