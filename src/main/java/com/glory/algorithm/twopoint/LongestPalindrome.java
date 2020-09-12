package com.glory.algorithm.twopoint;

/**
 * 最长会问子串
 *
 * @author Glory
 * @create 2020-08-16 15:58
 **/
public class LongestPalindrome {

    /**
     * 查询最长回文子串
     * @param src
     * @return
     */
    public static String find(String src) {
        int len = src.length();
        if (len < 2) {
            return src;
        }

        char[] arr = src.toCharArray();
        int[] max = new int[]{0,0};
        for (int i = 0; i < len; i++) {
            int[] res1 = palindrome(arr, i, i);
            int[] res2 = palindrome(arr, i, i + 1);
            max = max[1] < res1[1] ? res1 : max;
            max = max[1] < res2[1] ? res2 : max;
        }

        return src.substring(max[0], max[0] + max[1]);
    }

    private static int[] palindrome(char[] arr, int left, int right) {
        int len = 1;
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            len = right - left + 1;
            left--;
            right++;
        }

        // 返回数组：[start, len]
        return new int[]{left + 1, len};
    }

    public static void main(String[] args) {
        String scr = "abaaaaaa";
        System.out.println(find(scr));
    }
}
