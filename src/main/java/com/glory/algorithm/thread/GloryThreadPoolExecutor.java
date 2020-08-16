package com.glory.algorithm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Glory
 * @create 2020-07-28 10:04
 **/
public class GloryThreadPoolExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(12);
    }

}
