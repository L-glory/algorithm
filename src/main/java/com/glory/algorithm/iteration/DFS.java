package com.glory.algorithm.iteration;

import com.glory.algorithm.commons.TreeNode;

/**
 * 深度优先遍历
 *
 * @author Glory
 * @create 2020-08-19 22:18
 **/
public class DFS {

    public static void interator(TreeNode node) {

    }

    /**
     * 二叉树的最小深度
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        // 递归终止条件
        if (root == null) return 0;
        // 本层递归处理
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);

        // 本层递归恢复
        return (minLeft == 0 || minRight == 0) ?
                minLeft + minRight + 1 :
                Math.min(minLeft, minRight) + 1;
    }

    public static int maxDepth(TreeNode root) {
        return 1;
    }
}
