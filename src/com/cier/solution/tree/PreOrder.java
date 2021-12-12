package com.cier.solution.tree;

import com.cier.solution.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: N 叉树的谦虚遍历
 * @author: liuenci
 * @create: 2021-12-12 11:08
 **/
public class PreOrder {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        bfs(root);
        return res;
    }

    public void bfs(Node node) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        List<Node> children = node.children;
        for (int i = 0; i < children.size(); i++) {
            bfs(children.get(i));
        }
    }
}
