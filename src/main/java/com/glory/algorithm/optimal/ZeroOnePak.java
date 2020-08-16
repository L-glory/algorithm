package com.glory.algorithm.optimal;

import java.util.Scanner;

/**
 * 动态规划-0/1背包问题
 *
 * 描述：有N件物品和一个容量为V的背包。第i件物品的费用（即体积，下同）是w[i]，价值是val[i]。
 *       求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 *
 * @author Glory
 * @create 2020-01-13 17:08
 **/
public class ZeroOnePak {

    private static int[] f;
    private static int[] w;
    private static int[] val;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入物品数量N, 背包容量V
        int n = scanner.nextInt();
        int v = scanner.nextInt();

        f = new int[v + 1];
        w = new int[n + 1];
        val = new int[n + 1];
        // 输入各物品数据
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
            val[i] = scanner.nextInt();
        }
        printV(v);
        solve(n, v);
    }

    private static void printV(int v) {
        System.out.print("         ");
        for (int i = 0; i <= v; i++) {
            System.out.printf(" %4d" ,i);
        }
        System.out.println();
    }

    private static void printF() {
        for (int i : f) {
            System.out.printf(" %4d", i);
        }
        System.out.println();
    }

    private static void solve(int n, int v) {
        // 进阶公式：商品数量递增
        for (int i = 0; i <= n; i++) {
            // 状态枚举：剩余容量大小
            for (int c = v; c >= 0; c--) {
                // 剩余容量大于第i件物品重量
                if (c >= w[i]) {
                    f[c] = Math.max(f[c], f[c - w[i]] + val[i]);
                }
            }
            System.out.printf("%4d,%4d", w[i], val[i]);
            printF();
        }
        System.out.printf("最优值=%d", f[v]);
    }
}
