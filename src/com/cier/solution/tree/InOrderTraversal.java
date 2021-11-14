package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
 * 在二叉树中，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
 */
public class InOrderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal1(root.left);
        list.add(root.val);
        inorderTraversal1(root.right);
        return list;
    }

    public static void main(String[] args) {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        System.out.println(inOrderTraversal.inorderTraversal1(new TreeNode(1)));
    }
}
