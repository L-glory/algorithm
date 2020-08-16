package com.glory.algorithm.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Glory
 * @create 2020-07-15 10:36
 **/
public class OrderThreadOutput {
    private static Semaphore semaphore = new Semaphore(0, true);

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();



    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                orderExecute(0);
            }
        });
        thread.start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                orderExecute(1);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                orderExecute(2);
            }
        }).start();
        Thread.sleep(1000);
    }

    private static void orderExecute(int flag) {
        lock.lock();
        try {
            if (flag == 0) {
                System.out.print("a ");
                b.signal();
                c.await();
            } else if (flag == 1) {
                System.out.print("b ");
                c.signal();
                a.await();
            } else {
                System.out.print("c ");
                a.signal();
                b.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    private static void work1() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.print("a ");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(500);
        new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.print("b ");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(500);
        new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.print("c ");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        semaphore.release();
        Thread.sleep(500);
    }
}
