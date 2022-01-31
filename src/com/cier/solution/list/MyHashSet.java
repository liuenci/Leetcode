package com.cier.solution.list;

import java.util.ArrayList;
import java.util.List;

/**
 * [705] 设计哈希集合
 *
 * @author liuenci
 */
public class MyHashSet {

    List<Integer> array;


    public MyHashSet() {
        array = new ArrayList<>();
    }

    public void add(int key) {
        for (Integer integer : array) {
            if (key == integer) {
                return;
            }
        }
        array.add(key);
    }

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
