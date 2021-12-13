package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 二叉树的堂兄弟节点
 * @author: liuenci
 * @create: 2021-12-13 22:58
 **/
public class IsCousins {

    int xDepth = 0;
    int yDepth = 0;
    int xPre = 0;
    int yPre = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, 1, x, y, root.val);
        dfs(root.right, 1, x, y, root.val);
        return xDepth == yDepth && xPre != yPre;
    }

    public void dfs(TreeNode node, int depth, int x, int y, int pre) {
        if (node == null) {
            return; 
        }
        if (node.val == x) {
            xDepth = depth;
            xPre = pre;
        } else if (node.val == y) {
            yDepth = depth;
            yPre = pre;
        } else {
            pre = node.val;
            dfs(node.left, depth + 1, x, y, pre);
            dfs(node.right, depth + 1, x, y, pre);
        }
    }
}
