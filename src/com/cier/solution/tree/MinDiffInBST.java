package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 二叉搜索树节点最小距离
 * @author: liuenci
 * @create: 2021-12-12 12:34
 **/
public class MinDiffInBST {

    List<Integer> res = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        for (int i = 1; i < res.size(); i++) {
            min = Math.min(res.get(i) - res.get(i - 1), min);
        }
        return min;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }
}
