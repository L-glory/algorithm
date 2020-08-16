package com.glory.algorithm.compiler;

/**
 * @author Glory
 * @create 2020-05-27 15:26
 **/
public class JavaCCompiler {

    public static void main(String[] args) {
        Integer a = 1;     // -127 ~ 128 直接引用常量池
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;   // 语法糖：自动装箱，Integer.valueOf(1)
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);              // true
        System.out.println(e == f);              // false
        System.out.println(c == (a + b));        // true 存在算数运算符，自动拆箱
        System.out.println(c.equals(a + b));     // true
        System.out.println(g == (a + b));        // true
        System.out.println(g.equals(a + b));     // false equals默认处理类型转型关系
    }
}
