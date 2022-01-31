package com.cier.solution.list;

import java.util.ArrayList;
import java.util.List;

/**
 * [705] 设计哈希集合
 *
 * @author liuenci
 */
public class MyHashSet {

    /**
     * 无法使用内置的哈希集合来处理，那可以用 List 来实现一个哈希集合
     */
    List<Integer> array;

    public MyHashSet() {
        array = new ArrayList<>();
    }

    /**
     * 添加 key 的时候不能直接 array.add(key); 要考虑本身 List 中是否存在相同的 key
     * @param key
     */
    public void add(int key) {
        for (Integer integer : array) {
            if (key == integer) {
                return;
            }
        }
        array.add(key);
    }

    /**
     * 移除 key 的时候不能直接 array.remove(i); 这里的 key 是 int 类型，直接 remove 会走到重载方法按照索引移除数据的地方
     * @param key
     */
    public void remove(int key) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == key) {
                array.remove(i);
                break;
            }
        }
    }

    public boolean contains(int key) {
        for (Integer integer : array) {
            if (key == integer) {
                return true;
            }
        }
        return false;
    }
}
