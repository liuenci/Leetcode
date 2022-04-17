package com.cier.solution.tree;

import com.cier.solution.common.TreeNode;

import java.util.TreeMap;

// https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convert(nums, 0, nums.length - 1);
    }

    private TreeNode convert(int[] nums, int low, int hight) {
        if (low > hight) {
            return null;
        }
        int mid = (low + hight) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = this.convert(nums, low, mid - 1);
        node.right = this.convert(nums, mid + 1, hight);
        return node;
    }
}
