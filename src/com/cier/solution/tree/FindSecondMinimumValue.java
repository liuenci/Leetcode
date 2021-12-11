package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: Leetcode
 * @description: 二叉树中第二小的节点
 * @author: liuenci
 * @create: 2021-12-11 23:30
 **/
public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        bfs(root, set);
        return set.size() > 1 ? set.stream().collect(Collectors.toList()).stream().sorted().collect(Collectors.toList()).get(1) : -1;
    }

    public void bfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                set.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        FindSecondMinimumValue findSecondMinimumValue = new FindSecondMinimumValue();
        findSecondMinimumValue.findSecondMinimumValue(node1);
    }
}
