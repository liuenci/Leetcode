package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 二叉搜索树的最小绝对差
 * @author: liuenci
 * @create: 2021-12-08 23:19
 **/
public class GetMinimumDifference {
    int preVal;
    int min;

    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        preVal = list.get(0);
        min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            update(list.get(i));
        }
        return min;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        update(node.val);
        dfs(node.right);
    }

    public void update(int x) {
        if (Math.abs(x - preVal) < min) {
            min = Math.abs(x - preVal);
        }
        preVal = x;
    }
}
