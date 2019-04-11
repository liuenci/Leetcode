package com.cier.solution.LinkedList;

import java.util.HashMap;

// https://leetcode.com/problems/lru-cache/submissions/
public class LRUCache {
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
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
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return map.get(key).val;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else {
            Node node = new Node(key, value);
            insert(node);
        }
    }
    public void remove(Node node) {
        if (count > 0) {
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
        if (count > capacity) {
            remove(tail.prev);
        }
    }
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
