package com.glory.algorithm.iteration;

import com.glory.algorithm.commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度优先遍历
 *
 * @author Glory
 * @create 2020-08-19 21:21
 **/
public class BFS {

    public static void iterator(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 用于图的遍历
        // Set<String> filter = new HashSet<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        TreeNode node23 = new TreeNode(6);
        TreeNode node24 = new TreeNode(7);
        root.left = node11;
        root.right = node12;
        node11.left = node21;
        node11.right = node22;
        node12.left = node23;
        node12.right = node24;
        iterator(root);
    }
}
