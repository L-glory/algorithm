package com.glory.algorithm.commons;

import java.util.*;

/**
 * @author Glory
 * @create 2020-08-16 20:17
 **/
public class TwoSum {
    
    public static int[] findSum(int[] arr, int target) {
        int len = arr.length;
        if (len < 2) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int sub = target - arr[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    private static class TwoSumOptimizer {
        private Set<String> sum;
        private List<Integer> unms;

        public TwoSumOptimizer() {
            this.sum = new HashSet<>();
            this.unms = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int target = 30;
        System.out.println(Arrays.toString(findSum(arr, target)));
    }
}
