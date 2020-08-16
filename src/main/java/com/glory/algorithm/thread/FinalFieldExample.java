package com.glory.algorithm.thread;

/**
 * @author Glory
 * @create 2020-04-16 14:59
 **/
class FinalFieldExample {
    final int x;
    int y;
    static FinalFieldExample f;

    static boolean shutdown = false;

    public FinalFieldExample() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new FinalFieldExample();
    }

    static void reader() {
        while (!shutdown) {
            if (f != null) {
                int i = f.x;  // guaranteed to see 3
                int j = f.y;  // could see 0
                System.out.println(String.format("i=%d, j=%d\n", i, j));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(FinalFieldExample::reader, "read-thread");
        Thread t2 = new Thread(FinalFieldExample::writer, "read-thread");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println("shutdown");
        FinalFieldExample.shutdown = true;
    }
}
