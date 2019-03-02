package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        boolean flag = true;
        if (root == null) {
            return true;
        }
        flag = isSymmetricHelper(root.left,root.right);
        return flag;
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        boolean flag = true;
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else {
            if (left.val != right.val){
                return false;
            } else {
                flag = isSymmetricHelper(left.left, right.right);
            }
        }
        if (!flag) {
            return false;
        }
        flag = isSymmetricHelper(left.right, right.left);
        if (!flag) {
            return false;
        }
        return true;
    }
}
