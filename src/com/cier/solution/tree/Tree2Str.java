package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 根据二叉树创建字符串
 * @author: liuenci
 * @create: 2021-12-10 20:43
 **/
public class Tree2Str {

    String str = "";

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node2.left = node4;
        node1.right = node3;
        Tree2Str tree2Str = new Tree2Str();
        System.out.println(tree2Str.tree2str(node1));
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return str;
        }
        dfs(root, "");
//        return "()".equals(str) ? str : str.replace("()", "");
        return str;
    }

    public void dfs(TreeNode root, String s) {
        if (root == null) {
            str = str + s;
            return;
        }
        str += "(" + root.val;
        if (root.left == null && root.right == null) {
            return;
        }
        dfs(root.left, ")");
        dfs(root.right, "");
    }
}
