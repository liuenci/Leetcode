package com.cier.solution;

import java.util.List;

/**
 * @program: Leetcode
 * @description: 多叉树节点
 * @author: liuenci
 * @create: 2021-12-12 10:54
 **/
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
