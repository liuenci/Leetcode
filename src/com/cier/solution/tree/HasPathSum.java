package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 路径总和
 * @author: liuenci
 * @create: 2021-12-01 22:52
 **/
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode root1 = new TreeNode(11);
        root.left = root1;
        HasPathSum hasPathSum = new HasPathSum();
        System.out.println(hasPathSum.hasPathSum(root, 10));

    }
}
