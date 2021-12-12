package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 二叉搜索树中的搜索
 * @author: liuenci
 * @create: 2021-12-12 11:24
 **/
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
