package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

/**
 * @program: Leetcode
 * @description: 另一棵树的子树
 * @author: liuenci
 * @create: 2021-12-10 20:11
 **/
public class IsSubTree {

    /**
     * 三种情况：
     * 1.两棵树是同一棵树
     * 2.根节点的左子树和子树是同一棵树
     * 3.根节点的右子树和子树是同一棵树
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) ||  isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root != null && subRoot != null && root.val == subRoot.val){
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
