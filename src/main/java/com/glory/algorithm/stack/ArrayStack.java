package com.glory.algorithm.stack;

/**
 * 数组栈
 *
 * @author Glory
 * @create 2020-03-23 14:23
 **/
public class ArrayStack<E> {

    private Object[] stack;

    private int capacity;

    private int available;

    private int pos;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
        this.pos = 0;
        stack = new Object[capacity];
    }

    public void push(E elt) {
        checkCapacity();
        stack[pos] = elt;
        pos++;
    }

    public E pop() {
        pos--;
       Object elt = stack[pos];
       stack[pos] = null;
       return (E) elt;
    }

    private void checkCapacity() {
        // 扩容检测
        if (available == 0) {
            synchronized (this) {
                available = capacity;
                capacity  = capacity * 2;
                Object[] newStack = new Object[capacity];
                // 元素移动
                System.arraycopy(stack, 0, newStack, 0, available);
                stack = newStack;
                System.out.println(String.format("扩容操作：capacity=%d, available=%d", capacity, available));
            }
        }
        // 缩容检测
       /* else if (available >= (capacity * 1.5)) {
            synchronized (this) {
                available = available - (capacity / 2);
                capacity = capacity / 2;
                Object[] newStack = new Object[capacity];
                // 元素移动
                System.arraycopy(stack, 0, newStack, 0, available);
            }
        }*/
    }
}
