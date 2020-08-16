package com.glory.algorithm;

import java.util.Scanner;

/**
 * 自由落体计算
 *
 * @author Glory
 * @create 2020-01-13 11:09
 **/
public class FreeFalling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        System.out.println(getJourney(height));
        System.out.println(getTenthHigh(height));
    }

    /**
     * 统计出第5次落地时，共经过多少米?
     *
     * @param height 球的起始高度
     * @return 英文字母的个数
     */
    public static double getJourney(int height) {
        double h = height;
        return h + h * (2.00d - Math.pow(2.00d, -4d));
    }

    /**
     * 统计出第5次反弹多高?
     *
     * @param height 球的起始高度
     * @return 空格的个数
     */
    public static double getTenthHigh(int height) {
        return ((double) height) / Math.pow(2.00d, 5d);
    }

}
