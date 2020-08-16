package com.glory.algorithm.search;

import com.glory.algorithm.twopoint.TwoPoint;

import java.util.Arrays;

/**
 * @author Glory
 * @create 2020-08-13 22:31
 **/
public class Test {

    @org.junit.Test
    public void binarySearch() {
        int[] arr = new int[]{1,2,3};
        int target = 3;
        int i = TwoPoint.binarySearch(arr, target);
        System.out.println(Arrays.toString(arr));
        System.out.println("target=" + target + ", index=" + i);
    }

    @org.junit.Test
    public void twoSum() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int target = 15;
        System.out.println(Arrays.toString(TwoPoint.twoSum(arr, target)));
    }

    @org.junit.Test
    public void reverse() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(Arrays.toString(TwoPoint.reverse(arr)));
    }
}
