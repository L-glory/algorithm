package com.glory.algorithm.tree;

/**
 * 树的高度
 *
 * @author Glory
 * @create 2020-04-02 10:03
 **/
public class TreeHeight {

    private static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
