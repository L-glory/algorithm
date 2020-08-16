package com.glory.algorithm.important;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Glory
 * @create 2020-08-16 14:42
 **/
public class SwapArrayTest {

    @Test
    public void arrReverse() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int k = 30;
        int[] res = SwapArray.rotate(arr, k);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void arrCopy() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int k = 30;
        int[] res = SwapArray.copy(arr, k);
        System.out.println(Arrays.toString(res));
    }

}
