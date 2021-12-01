package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 二叉树的最小深度
 * @author: liuenci
 * @create: 2021-11-14 18:11
 **/
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 最小深度定义为到最近叶子节点的深度,当左右子树都为空，最小深度才为1 .
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
