package com.glory.algorithm.queue;

import java.util.Scanner;

/**
 * @author Glory
 * @create 2020-03-23 17:45
 * 顺序队列
 **/
public class ArrayQueue<E> {

    private Object[] queue;

    private int capacity;

    private int head;

    private int tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }


    public boolean push(E elt) {
        // 没有地方入列了
        if (head == capacity) {
            if (tail == 0) {
                System.out.println("队列已满");
                return false;
            }
            // 移动队列元素
            if (head - tail > 0) {
                System.out.println("移动元素");
                System.arraycopy(queue, tail, queue, 0, head - tail);
            }
            head -= tail;
            tail = 0;
        }

        // 还有剩余空间
        queue[head] = elt;
        head++;
        return true;
    }

    public E pop() {
        if (tail == capacity) {
            return null;
        }
        E elt = (E) queue[tail];
        queue[tail] = null;
        tail++;
        return elt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        System.out.println(String.format("容量=%d", capacity));
        ArrayQueue<Integer> aq = new ArrayQueue<>(capacity);
        int val;
        while ((val = scanner.nextInt()) > 0) {
            aq.push(val);
            if (val % 2 == 0) {
                Integer pop = aq.pop();
                System.out.println(String.format("弹出元素：%d", pop));
            } else if (val % 3 == 0) {
                Integer elt1 = aq.pop();
                Integer elt2 = aq.pop();
                System.out.println(String.format("弹出元素：%d, %d", elt1, elt2));
            }
        }
    }
}
