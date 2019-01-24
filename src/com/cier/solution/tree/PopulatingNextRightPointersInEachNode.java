package com.cier.solution.tree;

import com.cier.solution.common.TreeLinkNode;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        linkNodes(root.left, root.right);
    }

    private void linkNodes(TreeLinkNode t1, TreeLinkNode t2) {
        if (t1 == null) {
            return;
        }
        t1.next = t2;
        linkNodes(t1.left, t1.right);
        linkNodes(t2.left, t2.right);
        linkLeftToRight(t1.right, t2.left);
    }
    private void linkLeftToRight(TreeLinkNode t1, TreeLinkNode t2){
        if (t1 == null) {
            return;
        }
        t1.next = t2;
        linkLeftToRight(t1.right, t2.left);
    }
}
