package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 二叉树的直径
 * @author: liuenci
 * @create: 2021-12-09 23:17
 **/
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        max = Math.max(leftHeight + rightHeight, max);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
