package com.glory.algorithm.optimal;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 牛客
 *
 * @author Glory
 * @create 2020-01-15 17:11
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            maxNumSeq(scan.nextLine());
        }
    }

    private static void maxNumSeq(String line) {
        if (line == null || "".equals(line)) {
            System.out.println(line);
        }
        LinkedList<int[]> queue = new LinkedList<>();
        int len = line.length();

        int start = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            int code = line.charAt(i);
            if (48 <= code && code <= 57) {
                if (start == -1) {
                    start = i;
                }
                // 末尾
                if (i == len -1) {
                    maxLen = record(i, start, maxLen, queue);
                }
            } else if (start != -1){
                maxLen = record(i - 1, start, maxLen, queue);
                // 重置指针
                start = -1;
            }
        }

        // 打印结果
        int[] item;
        while ((item = queue.pollLast()) != null) {
            System.out.print(line.substring(item[0], item[1] + 1));
        }
        System.out.println("," + maxLen);
    }

    private static int record(int i, int start, int maxLen, LinkedList<int[]> queue) {
        int interval = i - start + 1;
        if (interval > maxLen) {
            maxLen = interval;
            queue.clear();
            queue.offer(new int[]{start, i});
        } else if (interval == maxLen){
            queue.offerFirst(new int[]{start, i});
        }

        return maxLen;
    }
}
