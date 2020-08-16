package com.glory.algorithm.queue;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

/**
 * 无锁并发环形队列
 *
 * @author Glory
 * @create 2020-03-24 9:05
 **/
public class ConcurrentRingQueue<E> {

    /**
     * unsafe魔法类，用于CAS调用
     */
    private static Unsafe unsafe;
    static {
        try {
            final PrivilegedExceptionAction<Unsafe> action = () -> {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe) theUnsafe.get(null);
            };
            unsafe = AccessController.doPrivileged(action);
        }
        catch (Exception e){
            throw new RuntimeException("[concurrent-ring-queue] Unable to load unsafe", e);
        }
    }

    /**
     * 空元素
     */
    private static final Object EMPTY_ELMENET = null;

    /**
     * 环形队列容量
     */
    private int capacity;

    /**
     * 可用长度
     */
    private volatile int available;

    /**
     * 队列头位置
     */
    private volatile int head;

    /**
     * 队列尾位置
     */
    private volatile int tail;

    /**
     * 队列数组
     */
    private volatile Object[] queue;

    public ConcurrentRingQueue(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
        this.head = 0;
        this.tail = 0;
        this.queue = new Object[capacity];
    }

    public boolean offer(E e) {
        // 容量已满
        if (available == 0) {
            System.out.println("容量已满");
            return false;
        }
        return false;
    }

    public E poll() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println("unsafe测试");
    }
}
