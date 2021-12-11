package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 二叉树的坡度
 * @author: liuenci
 * @create: 2021-12-09 23:45
 **/
public class FindTilt {

    int sum = 0;

    /**
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
