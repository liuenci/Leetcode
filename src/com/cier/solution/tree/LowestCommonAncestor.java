package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 二叉树的最近公共祖先
 * @author: liuenci
 * @create: 2021-12-18 23:14
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> res1 = new ArrayList<>();
        List<TreeNode> res2 = new ArrayList<>();
        path(root, p, res1);
        path(root, p, res2);
        return equals(res1, res2);
    }

    /**
     * TODO 获取某个节点的路径
     * @param root
     * @param node
     * @param res
     */
    public void path(TreeNode root, TreeNode node, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        res.add(root);
        if (root == node) {
            return;
        }
        if (res.get(res.size() - 1) != node) {
            path(root.left, node, res);
        }
        if (res.get(res.size() - 1) != node) {
            path(root.right, node, res);
        }
        if (res.get(res.size() - 1) != node) {
            res.remove(res.size() - 1);
        }
    }

    public TreeNode equals(List<TreeNode> res1, List<TreeNode> res2) {
        int size = res1.size() > res2.size() ? res2.size() : res1.size();
        TreeNode res = null;
        for (int i = 0; i < size; i++) {
            if (res1.get(i).val == res2.get(i).val) {
                res = res1.get(i);
            } else {
                break;
            }
        }
        return res;
    }
}
