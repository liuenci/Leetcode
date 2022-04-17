package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(1 + maxDepth(root.left),1 + maxDepth(root.right));
        }

    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
}
