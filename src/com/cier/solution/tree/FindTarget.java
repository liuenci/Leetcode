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

    List<Integer> res = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        dfs(root);
        for (Integer a : res) {
            if (set.contains(k - a)) {
                return true;
            } else {
                set.add(k - a);
            }
        }
        return false;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        FindTarget findTarget = new FindTarget();
        boolean target = findTarget.findTarget(node1, 3);
        System.out.println(target);

    }
}
