package com.cier.solution.tree;

import com.cier.solution.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: N 叉树的后序遍历
 * @author: liuenci
 * @create: 2021-12-12 11:16
 **/
public class PostOrder {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        bfs(root);
        return res;
    }

    public void bfs(Node node) {
        if (node == null) {
            return;
        }


        List<Node> children = node.children;
        for (int i = 0; i < children.size(); i++) {
            bfs(children.get(i));
        }
        res.add(node.val);
    }
}
