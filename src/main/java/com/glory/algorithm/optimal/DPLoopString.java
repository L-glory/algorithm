package com.glory.algorithm.optimal;

import java.util.Scanner;

/**
 * 动态规划-最大回文子串
 *
 * @author Glory
 * @create 2020-01-15 14:25
 **/
public class DPLoopString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            maxLoop(scanner.nextLine());
        }
    }

    private static void maxLoop(String line) {
        if (line == null || line.length() < 2) {
            System.out.println(line);
        }

        int len = line.length();
        int start = 0;
        int end = 0;
        int maxLen = 1;

        boolean[][] f = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // r - l <= 2    2 <= 子串长度 <= 3
                if (line.charAt(l) == line.charAt(r) && (r - l <= 2 || f[l + 1][r - 1])) {
                    f[l][r] = true;

                    int interval = r - l + 1;
                    if (interval > maxLen) {
                        maxLen = interval;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        System.out.println(line.substring(start, end + 1));
    }
}
