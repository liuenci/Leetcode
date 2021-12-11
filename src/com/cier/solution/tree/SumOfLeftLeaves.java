package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 左叶子之和
 * @author: liuenci
 * @create: 2021-12-06 22:12
 **/
public class SumOfLeftLeaves {

    /**
     * 1
     * 2 3
     * 4 5
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.left != null && isLeafNode(root.left)) {
            result += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + result;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
