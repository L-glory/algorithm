package com.glory.algorithm.search;

/**
 * 位图
 *
 * @author Glory
 * @create 2020-07-08 10:47
 **/
public class ByteMap {

    private byte[] map;

    private int capacity;

    public ByteMap(int capacity) {
        this.capacity = capacity;
        this.map = new byte[capacity / 8 + 1];
    }

    public boolean set(int value) {
        if (value > capacity) return false;
        int mapIndex = value / 8;
        int bitIndex = value % 8;
        map[mapIndex] |= (1 << bitIndex);
        return true;
    }

    public boolean get(int value) {
        if (value > capacity) return false;
        int mapIndex = value / 8;
        int bitIndex = value % 8;
        return (map[mapIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        ByteMap byteMap = new ByteMap(102400);
        byteMap.set(124);
        byteMap.set(111);
        byteMap.set(4765);
        System.out.println(byteMap.get(124));
        System.out.println(byteMap.get(123));
        System.out.println(byteMap.get(22222));
        System.out.println(byteMap.get(4765));
    }
}
