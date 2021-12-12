package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 递增顺序搜索树
 * @author: liuenci
 * @create: 2021-12-12 15:58
 **/
public class IncreasingBST {

    List<TreeNode> res = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode node = res.get(0);
        TreeNode pre = node;
        for (int i = 1; i < res.size(); i++) {
            pre.right = new TreeNode(res.get(i).val);
            pre = pre.right;
        }
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
