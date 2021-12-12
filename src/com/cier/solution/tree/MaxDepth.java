package com.cier.solution.tree;


import com.cier.solution.Node;

import java.util.List;

/**
 * @program: Leetcode
 * @description: N 叉树的最大深度
 * @author: liuenci
 * @create: 2021-12-12 10:56
 **/
public class MaxDepth {


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        List<Node> children = root.children;
        int max = 0;
        for (int i = 0; i < children.size(); i++) {
            int depth = maxDepth(children.get(i));
            max = Math.max(max, depth);
        }

        return max + 1;
    }
}
