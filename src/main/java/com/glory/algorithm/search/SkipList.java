package com.glory.algorithm.search;

import java.util.Random;
import java.util.Scanner;

/**
 * 跳跃链表
 *
 * @author Glory
 * @create 2020-03-26 18:05
 **/
public class SkipList {

    /**
     * 索引最大层数
     */
    private static final int MAX_LEVEL = 16;

    /**
     * 随机种子
     */
    private Random random = new Random();

    /**
     * 链表头结点
     */
    private Node head = new Node(MAX_LEVEL);

    /**
     * 索引总层数
     */
    private int levelCount = 1;

    /**
     * 元素添加方法
     * @param val
     * @return
     */
    public SkipList add(int val) {
        // 初始化level层高，第一次添加元素，level=1，其他情况随机生成层数
        int level = head.forwards[0] == null ? 1 : randomLevel();
        // 控制索引层高度在合理范围
        if (level > levelCount) {
            level = ++levelCount;
        }

        // 创建新节点
        Node newNode = new Node(level, val);

        /*
         * 搜索插入位置，从head的最上层开始，在同一层往前搜索，
         * 找到最后一个小于val的位置，执行插入操作
         * 1、如果当前层的高度，小于or等于newNode的层高，执行newNode的层衔接操作
         * 2、如果当前层的高度，大于newNode的层高，继续往下一层执行搜索
         * 直至找到最底层的数据链表
         *
         */
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            // 找到当前层的插入点
            while (p.forwards[i] != null && p.forwards[i].data < val) {
                p = p.forwards[i];
            }

            // 如果当前层的高度，小于or等于newNode的层高，插入newNode的索引
            if (level > i) {
                newNode.forwards[i] = p.forwards[i];
                p.forwards[i] = newNode;
            }
        }

        return this;
    }

    /**
     * 跳表查找方法
     * @param val
     * @return
     */
    public Node get(int val) {
        /*
         * 找到目标节点的前一个节点
         */
            Node p = head;
        for (int i = levelCount -1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < val) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == val) {
            return p.forwards[0];
        }
        return null;
    }

    public boolean del(int val) {
        // 记录待删除节点每层索引的前一个节点位置
        Node[] update = new Node[levelCount];

        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < val) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        // 判断是否存在待删除的节点
        if (p.forwards[0] != null && p.forwards[0].data == val) {
            for (int i = levelCount - 1; i >= 0; i--) {
                /*
                 * 所有索引跳过一个节点
                 * 注意：
                 *  1、update[i].forwards[i].data == val这个条件不能省，update[]列表的额索引，
                 *     指向的下一个索引不一定是待删除节点
                 */
                Node levelNode = update[i].forwards[i];
                if ( levelNode != null && levelNode.data == val) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
            return true;
        }

        return false;
    }

    /**
     * 随机层数
     * @return
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public void print() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ----> ");
            p = p.forwards[0];
        }
        System.out.println("null");
    }

    /**
     * 节点数据结构定义
     */
    private class Node {
        private int data = -1;
        private Node[] forwards;

        public Node(int level) {
            this.forwards = new Node[level];
        }

        public Node(int level, int data) {
            this.data = data;
            this.forwards = new Node[level];
        }

        @Override
        public String toString() {
            return "{data=" + data + ", level=" + forwards.length + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println("跳表已初始化，请输入命名进行操作；操作说明请输入help。");
        SkipList skipList = new SkipList();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!"quit".equals(line = scanner.nextLine())) {
            String[] cmds = line.split("\\s+");
            switch (cmds[0]) {
                case "help":
                    System.out.println("==================================");
                    System.out.println("添加：add val");
                    System.out.println("删除：del val");
                    System.out.println("查找：get val");
                    System.out.println("==================================");
                    break;
                case "print":
                    skipList.print();
                    break;
                case "add":
                    skipList.add(Integer.parseInt(cmds[1]));
                    System.out.println("add ok.");
                break;
                case "del":
                    boolean del = skipList.del(Integer.parseInt(cmds[1]));
                    System.out.println("del result=" + del);
                    break;
                case "get":
                    Node node = skipList.get(Integer.parseInt(cmds[1]));
                    System.out.println("get result=" + node);
                    break;
                default:
                    System.out.println("命令错误！");
            }
        }
        System.out.println("删除链表，系统退出。");
    }
}
