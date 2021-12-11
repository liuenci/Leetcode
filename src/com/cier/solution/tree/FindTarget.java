package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Leetcode
 * @description: 两数之和IV - 输入 BST
 * @author: liuenci
 * @create: 2021-12-11 22:55
 **/
public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}
