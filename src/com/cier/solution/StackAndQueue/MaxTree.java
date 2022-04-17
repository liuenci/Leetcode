package com.cier.solution.StackAndQueue;

import com.cier.solution.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode-cn.com/problems/maximum-binary-tree/description/
public class MaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 创建节点数组，将入参中的值传入节点数组中。
        TreeNode[] nArr = new TreeNode[nums.length];
        for (int i = 0; i < nArr.length; i++) {
            nArr[i] = new TreeNode(nums[i]);
        }

        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
        HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();

        for (int i = 0; i != nArr.length; i++) {
            TreeNode curNode = nArr[i];
            // 如果栈不为空并且当前栈顶的值小于当前节点的值，就将栈顶的值弹出
            while (!stack.isEmpty() && stack.peek().val < curNode.val) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1; i != -1; i--) {
            TreeNode curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().val < curNode.val) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        // 以上步骤是为了构建两个HashMap,键节点的值大于键的节点的值。
        TreeNode head = null;
        for (int i = 0; i < nArr.length; i++) {
            TreeNode curNode = nArr[i];
            TreeNode left = lBigMap.get(curNode);
            TreeNode right = rBigMap.get(curNode);
            if (null == left && null == right) {
                // 如果 left 和 right 都为 null，则说明 curNode 为根节点。
                head = curNode;
            } else if (null == left) {
                // 如果 lefe == null 而 right != null 说明 curNode 有右节点没有左节点。
                if (null == right.left) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (null == right) {
                if (null == left.left) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                TreeNode parent = left.val < right.val ? left : right;
                if (null == parent.left) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        TreeNode node = stack.pop();
        if (stack.isEmpty()) {
            map.put(node, null);
        } else {
            // 如果栈不为空，那么将当前节点作为键，栈顶节点作为值放入 Hashmap
            map.put(node, stack.peek());
        }
    }

    // 自己手撕的
    public TreeNode MaxTree(int[] nums) {
        TreeNode[] nArr = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nArr[i] = new TreeNode(nums[i]);
        }
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> lBigTree = new HashMap<>();
        HashMap<TreeNode, TreeNode> rBigTree = new HashMap<>();
        for (int i = 0; i < nArr.length; i++) {
            while (!stack.isEmpty() && stack.peek().val < nArr[i].val) {
                popSetMap(stack, lBigTree);
            }
            stack.push(nArr[i]);
        }
        while (!stack.isEmpty()) {
            popSetMap(stack, lBigTree);
        }
        for (int i = nArr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val < nArr[i].val) {
                popSetMap(stack, rBigTree);
            }
            stack.push(nArr[i]);
        }
        while (!stack.isEmpty()) {
            popSetMap(stack, rBigTree);
        }
        TreeNode head = null;
        for (int i = 0; i < nArr.length; i++) {
            TreeNode curNode = nArr[i];
            TreeNode left = lBigTree.get(curNode);
            TreeNode right = rBigTree.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                TreeNode parents = lBigTree.get(curNode).val < rBigTree.get(curNode).val ? left : right;
                if (parents.left == null) {
                    parents.left = curNode;
                } else {
                    parents.right = curNode;
                }
            }
        }
        return head;
    }

    // 自己手撕
    public void popSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        TreeNode node = stack.pop();
        if (stack.isEmpty()) {
            map.put(node, null);
        } else {
            map.put(node, stack.peek());
        }
    }

    public TreeNode MaximumBinaryTree(int[] nums) {
        LinkedList<TreeNode> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curNode = new TreeNode(nums[i]);
            // list.peek() 代表 linklist 的第一个节点
            while (!list.isEmpty() && list.peek().val < curNode.val) {
                // list.pop() 代表弹出 linklist 的第一个节点。
                curNode.left = list.pop();
            }
            if (!list.isEmpty()) {
                list.peek().right = curNode;
            }
            // list.push() 代表在 list 的头部压入一个节点
            list.push(curNode);
        }
        // list.removeLast() 代表移除 linklist 的最后一个节点
        return list.isEmpty() ? null : list.removeLast();
    }
}
