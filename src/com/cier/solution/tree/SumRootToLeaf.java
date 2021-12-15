package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从根到叶的二进制数之和
 */
public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += Integer.parseInt(res.get(i), 2);
        }
        return sum;
    }

    public List<String> res = new ArrayList<>();

    public void dfs(TreeNode root, String str) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            str = str + root.val;
            res.add(str);
            return;
        }
        if (root.left != null) {
            dfs(root.left, str + root.val);
        }
        if (root.right != null) {
            dfs(root.right, str + root.val);
        }
    }
}
