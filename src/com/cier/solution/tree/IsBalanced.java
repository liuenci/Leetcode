package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 是否平衡二叉树
 * @author: liuenci
 * @create: 2021-11-14 17:58
 **/
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
    }

    public int maxDepth(TreeNode node) {
        return node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
