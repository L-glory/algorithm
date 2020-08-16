package com.glory.algorithm.optimal;

import java.util.Stack;

/**
 * 运算栈
 * 1、一个操作数栈
 * 2、一个操作符栈
 * 解析到操作数，入操作数栈
 * 解析到操作符：
 *   1)、操作符栈为空，入栈
 *   2)、操作符比操作符栈顶元素优先级高，入栈
 *   3)、操作符比操作符栈顶元素优先级低，
 *
 * @author Glory
 * @create 2020-03-23 15:37
 **/
public class OpsStack {

    private Stack<Integer> digit;

    private Stack<String> ops;

    public OpsStack() {
        this.digit = new Stack<>();
        this.ops   = new Stack<>();
    }

    public int parse(String line) {
        return 1;
    }

    public static void main(String[] args) {
        String[] split = "121*1212%1212".split("[\\*%]");
        System.out.println(split);
    }
}
