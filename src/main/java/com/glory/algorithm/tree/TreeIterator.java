package com.glory.algorithm.tree;

import java.util.ArrayDeque;

/**
 * 树的遍历
 *
 * @author Glory
 * @create 2020-03-31 16:33
 **/
public class TreeIterator {

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 树的分层遍历
     * @param root
     */
    public static void levelIter(Node root) {
        if (root == null) {
            return;
        }

        // 双端队列
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            // 打印节点
            Node node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 二叉树：查找节点q、p的最近公共祖先节点
     * O(n)级别耗时
     * @param root
     * @param q
     * @param p
     * @return
     */
    public static Node findLowestCommonNode(Node root, Node q, Node p) {
        // 递归终止条件
        if (root == null || root == q || root == p) {
            return root;
        }

        // 左递归
        Node left = findLowestCommonNode(root.left, q, p);
        // 右递归
        Node right = findLowestCommonNode(root.right, q, p);

        // 左、右递归结果判断
        return left == null ? right : right == null ? left : root;
    }

    /**
     * Binary Search Tree
     * 二叉搜索树：查找节点q、p的最近公共祖先节点
     * @param root
     * @param q
     * @param p
     * @return
     */
    public static Node searchLowestCommonNode(Node root, Node q, Node p) {
        // case1：空二叉树
        // case2：查找的某一个节点等于root节点
        if (root == null || root == q || root == p) {
            return root;
        }

        // case3: 两个节点都小于root节点
        if (q.val < root.val && p.val < root.val) {
            return searchLowestCommonNode(root.left, q, p);
        }
        // case4: 两节点都大于root节点
        else if (q.val > root.val && p.val > root.val) {
            return searchLowestCommonNode(root.right, q, p);
        }
        // case5：两节点跟root对比，一大一小，分散在root的左右子树，公共节点只有root
        else {
            return root;
        }
    }

    /**
     * Binary Search Tree
     * 二叉搜索树：查找节点q、p的最近公共祖先节点
     * 非递归算法
     * @param root
     * @param q
     * @param p
     * @return
     */
    public static Node searchLowestCommonNode2(Node root, Node q, Node p) {
        while (root != null) {
            // case1: 两节点都小于root
            if (q.val < root.val && p.val < root.val) {
                root = root.left;
            } else if (q.val > root.val && p.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
