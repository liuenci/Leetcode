package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 二叉树的所有路径
 * @author: liuenci
 * @create: 2021-12-02 23:07
 **/
public class BinaryTreePaths {
    List<String> strList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return strList;
        }
        this.cal(root, "");
        return strList;
    }

    private void cal(TreeNode root, String str) {
        if (root == null) {
            return;
        }
        str += root.val;
        if (root.left == null && root.right == null) {
            strList.add(str);
        } else {
            cal(root.left, str + "->");
            cal(root.right, str + "->");
        }
    }
}
