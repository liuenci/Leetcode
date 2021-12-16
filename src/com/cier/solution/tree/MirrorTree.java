package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 二叉树的镜像
 * @author: liuenci
 * @create: 2021-12-16 22:42
 **/
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
