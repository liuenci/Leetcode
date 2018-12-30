package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

// 二叉树的前序中序后序递归实现
public class TreeRecur {
    /**
     * 前序遍历
     * @param head
     */
    public void preOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历
     * @param head
     */
    public void inOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    public void posOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        head.left = left;
        head.right = right;
        TreeRecur treeRecur = new TreeRecur();
        treeRecur.preOrderRecur(head);
        System.out.println();
        treeRecur.inOrderRecur(head);
        System.out.println();
        treeRecur.posOrderRecur(head);
    }
}
