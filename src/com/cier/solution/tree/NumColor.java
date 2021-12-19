package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Leetcode
 * @description: 开幕式焰火
 * @author: liuenci
 * @create: 2021-12-19 11:52
 **/
public class NumColor {

    Set<Integer> set = new HashSet<>();

    public int numColor(TreeNode root) {
        dfs(root);
        return set.size();
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
