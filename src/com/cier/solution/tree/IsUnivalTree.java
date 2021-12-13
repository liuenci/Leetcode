package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 单值二叉树
 * @author: liuenci
 * @create: 2021-12-13 22:14
 **/
public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        int i = root.val;
        return dfs(root, i);
    }

    public boolean dfs(TreeNode node, int val) {
        if (node != null && node.val != val) {
            return false;
        }
        if (node == null) {
            return true;
        } else {
            return dfs(node.left, val) && dfs(node.right, val);
        }

    }
}
