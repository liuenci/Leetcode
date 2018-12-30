package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.Stack;

// 二叉树的前序中序后序遍历-非递归
public class TreeUnRecur {
    /**
     * 前序遍历
     * @param head
     */
    public void preOrderUnRecur(TreeNode head){
        System.out.print("pre-order:");
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历
     * @param head
     */
    public void inOrderUnRecur(TreeNode head){
        System.out.print("in-order: ");
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }

            }
        }
        System.out.println();
    }

    /**
     * 后序遍历1
     * @param head
     */
    public void posOrderUnRecur1(TreeNode head){
        System.out.print("pos-order: ");
        if (head != null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }
    /**
     * 后序遍历2
     * @param h
     */
    public void posOrderUnRecur2(TreeNode h){
        System.out.print("pos-order: ");
        if (h != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            TreeNode c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right){
                    stack.push(c.left);
                } else if (c.right != null && h != c.right){
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().val + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        head.left = left;
        head.right = right;
        TreeUnRecur treeRecur = new TreeUnRecur();
        treeRecur.preOrderUnRecur(head);
        System.out.println();
        treeRecur.inOrderUnRecur(head);
        System.out.println();
        treeRecur.posOrderUnRecur1(head);
        System.out.println();
    }
}
