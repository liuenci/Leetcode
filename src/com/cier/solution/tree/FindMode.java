package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 二叉搜索树中的众数
 * 中序遍历二叉搜索树等于遍历有序数组
 * @author: liuenci
 * @create: 2021-12-06 22:53
 **/
public class FindMode {
    int curVal = 0;
    int count = 0;
    int maxTime = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        find(root);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public void find(TreeNode node) {
        if (node == null) {
            return;
        }
        find(node.left);
        update(node.val);
        find(node.right);
    }

    /**
     * 0 1 1 1 2 2 3
     *
     * @param x
     */
    public void update(int x) {
        if (curVal == x) {
            count++;
        } else {
            count = 1;
            curVal = x;
        }

        if (count == maxTime) {
            list.add(curVal);
        } else if (count > maxTime) {
            list.clear();
            list.add(curVal);
            maxTime = count;
        }
    }
}
