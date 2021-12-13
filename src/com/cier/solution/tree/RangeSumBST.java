package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 二叉搜索树的范围和
 * @author: liuenci
 * @create: 2021-12-13 22:08
 **/
public class RangeSumBST {

    List<Integer> res = new ArrayList<>();

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root);

        int left = index(low);
        int right = index(high);
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += res.get(i);
        }
        return sum;
    }

    public int index(int val) {
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == val) {
                return i;
            }
        }
        return -1;
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
