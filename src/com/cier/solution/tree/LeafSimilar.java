package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 叶子相似的树
 * @author: liuenci
 * @create: 2021-12-12 12:53
 **/
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        leaf(root1, res1);
        leaf(root2, res2);
        return equals(res1, res2);
    }

    public boolean equals(List<Integer> res1, List<Integer> res2) {
        if (res1.size() != res2.size()) {
            return false;
        } else {
            for (int i = 0; i < res1.size(); i++) {
                if (!res1.get(i).equals(res2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public void leaf(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        } else {
            leaf(node.left, res);
            leaf(node.right, res);
        }
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left != null || node.right != null) {
            return false;
        }
        return true;
    }
}
