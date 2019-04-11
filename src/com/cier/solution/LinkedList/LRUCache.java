package com.cier.solution.LinkedList;

import java.util.HashMap;

// https://leetcode.com/problems/lru-cache/submissions/
public class LRUCache {
    // HashMap 保证插入结点和查找结点的时间复杂度为 O(1)
    HashMap<Integer,Node> map;
    // head.next 是 most recently 的结点
    Node head;
    // tail.prev 是 least recently 的结点
    Node tail;
    // capacity 表示最大容量
    int capacity;
    // count 表示当前已有结点数
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        // 如果 key 在 HashMap 中，先拿到该结点，删除结点，再插入结点。
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return map.get(key).val;
        }
        // 如果不在就返回 -1
        return -1;
    }
    public void put(int key, int value) {
        // 如果 key 在 HashMap 中，和 get 类似，也是先拿到该结点，删除结点，再插入结点。
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else {
            // 如果 key 不在 HashMap 中，那么是一个新的结点，直接插入即可。
            Node node = new Node(key, value);
            insert(node);
        }
    }


    public void remove(Node node) {
        if (count > 0) {
            // 在 map 中移除结点前，先将双向链表的指针指向进行修改
            Node prev = node.prev;
            Node next = node.next;
            node.prev = null;
            node.next = null;
            next.prev = prev;
            prev.next = next;
            map.remove(node.key);
            count--;
        }
    }
    public void insert(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        map.put(node.key,node);
        count++;
        // 如果结点数超过可允许容量，将 least recently 的结点移除
        if (count > capacity) {
            remove(tail.prev);
        }
    }

    /**
     * 维护一个类似双向链表的数据结构，包含前驱、后继以及 K-V 结构
     */
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public Node(){
        }
    }

}
