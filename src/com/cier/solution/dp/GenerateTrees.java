package com.cier.solution.dp;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: [95] 不同的二叉搜索树 2
 * @author: liuenci
 * @create: 2022-02-25 21:52
 **/
public class GenerateTrees {

    /**
     * 题目需要满足二叉搜索树的特性，必须保证左子树的值比父节点小，右子树的值比父节点大
     * 题目可以转化为，给定一串排序的数字，能够构建中序遍历的数组有多少个
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        int[] array = new int[n];
        // 初始化数组
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return new ArrayList<>();
    }
}
