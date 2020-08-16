package com.glory.algorithm.bytecode;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 字节码debug
 *
 * @author Glory
 * @create 2020-04-26 15:58
 **/
public class ByteCodeDebuger {

    private static final ReentrantReadWriteLock WR_LOCK = new ReentrantReadWriteLock();

    private static final Object LOCK = new Object();

    private static int total = 0;

    public static void main(String[] args) {
        synchronized (LOCK) {
            var i = 10;
            i++;
            total += i;
        }
        String name = "Liu-" + "Glory";
    }
}
