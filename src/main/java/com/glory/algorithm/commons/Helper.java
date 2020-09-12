package com.glory.algorithm.commons;

/**
 * 工具类
 *
 * @author Glory
 * @create 2020-08-25 23:24
 **/
public class Helper {

    private Helper(){}

    public static void print(Node node) {
        while (node != null && node.next != null) {
            System.out.print(node.val + " --> ");
            node = node.next;
        }
        System.out.println(node.val);
    }
}
