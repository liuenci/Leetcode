package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(1 + maxDepth(root.left),1 + maxDepth(root.right));
        }

    }
}
