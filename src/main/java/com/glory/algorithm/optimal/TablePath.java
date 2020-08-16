package com.glory.algorithm.optimal;

import java.util.Scanner;

/**
 * 棋盘路径问题
 *
 * @author Glory
 * @create 2020-01-15 15:53
 **/
public class TablePath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(combination(x, y));
        }
    }

    // 组合计算: C(x + y, x) = C(x + y, y)
    // 计算公式：(x + y)! / x![(x + y) - x]!
    private static int combination(int x, int y) {
        return factorial(x + y) / (factorial(x) * factorial(y));
    }

    private static int factorial(int n) {
        int sum = 1;
        for (int i = n; i > 1; i--) {
            sum *= i;
        }
        return sum;
    }

    // 动态规划
    private static int dpPath(int x, int y) {
        int[][] f = new int[x + 1][y + 1];
        for (int i = 1; i<= x; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= y; i++) {
            f[0][i] = 1;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[x][y];
    }
}
