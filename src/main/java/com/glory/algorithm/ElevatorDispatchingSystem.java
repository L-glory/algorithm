package com.glory.algorithm;

/**
 * @author Glory
 * @create 2020-03-26 14:38
 **/
public interface ElevatorDispatchingSystem {

    /**
     * 我要下楼
     * @param floor   楼层编号
     * @return
     */
    boolean up(final int floor);

    /**
     * 我要上楼
     * @param floor   楼层编号
     * @return
     */
    boolean down(final int floor);


    /**
     * 添加目的楼层编号
     * @param floor
     * @return
     */
    boolean addFloor(final int floor);


    /**
     * 启动
     * @return
     */
    boolean start();

    /**
     * 关闭
     * @return
     */
    boolean stop();

    /**
     * 暂停
     * @return
     */
    boolean suspend();
}
