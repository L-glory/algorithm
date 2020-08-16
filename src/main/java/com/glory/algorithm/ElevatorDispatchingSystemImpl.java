package com.glory.algorithm;

/**
 * @author Glory
 * @create 2020-03-26 14:45
 **/
public class ElevatorDispatchingSystemImpl implements ElevatorDispatchingSystem {

    /**
     * 电梯目前所在楼层位置
     */
    private static int pos = 0;

    /**
     * 电梯是否下降
     */
    private boolean isDown;

    /**
     * 楼层列表
     */
    private int[] floors;

    /**
     * 总楼层
     */
    private int capacity;

    public ElevatorDispatchingSystemImpl(int capacity) {
        this.capacity = capacity;
        this.floors   = new int[capacity];
        this.isDown   = false;
    }

    @Override
    public boolean up(int floor) {
        return false;
    }

    @Override
    public boolean down(int floor) {
        return false;
    }

    @Override
    public boolean addFloor(int floor) {
        return false;
    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public boolean suspend() {
        return false;
    }
}
