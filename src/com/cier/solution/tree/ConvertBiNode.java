package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: BiNode
 * @author: liuenci
 * @create: 2021-12-19 11:16
 **/
public class ConvertBiNode {

    List<TreeNode> res = new ArrayList<>();

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        TreeNode node = res.get(0);
        TreeNode pre = node;
        for (int i = 1; i < res.size(); i++) {
            pre.left = null;
            pre.right = res.get(i);
            pre = pre.right;
        }
        pre.left = null;
        return node;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        res.add(node);
        dfs(node.right);
    }
}
