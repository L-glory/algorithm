package com.glory.algorithm.tree;

/**
 * 二叉搜索树
 *
 * 1、若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 2、若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 3、任意节点的左、右子树也分别为二叉查找树；
 * 4、没有键值相等的节点。
 *
 * @author Glory
 * @create 2020-04-01 14:58
 **/
public class BinarySearchTree {

    /**
     * 二叉树根节点
     */
    private Node root;

    /**
     * 节点数量
     */
    private int size;

    private static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public BinarySearchTree add(int val) {
        if (root == null) {
            root = new Node(val);
            size++;
            return this;
        }

        Node next = root;
        while (next != null) {
            // 往右
            if (next.val < val) {
                if (next.right == null) {
                    next.right = new Node(val);
                    size++;
                    break;
                }
                next = next.right;
            }
            // 往左
            else {
                if (next.left == null) {
                    next.left = new Node(val);
                    size++;
                    break;
                }
                next = next.left;
            }
        }
        return this;
    }

    public boolean del(int val) {
        if (root == null) {
            return false;
        }

        Node parent = root;
        Node next   = root;
        while (next != null) {
            return false;
        }
        return false;
    }
}
