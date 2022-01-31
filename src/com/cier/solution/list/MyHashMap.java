package com.cier.solution.list;

import java.util.ArrayList;
import java.util.List;

/**
 * [706] 设计哈希映射
 * @author liuenci
 */
public class MyHashMap {

    List<Integer> keyList;
    List<Integer> valueList;

    public MyHashMap() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }

    public void put(int key, int value) {
        for (Integer integer : keyList) {
            if (key == integer) {
                this.remove(key);
                break;
            }
        }
        keyList.add(key);
        valueList.add(value);
    }

    public int get(int key) {
        for (int i = 0; i < keyList.size(); i++) {
            if (key == keyList.get(i)) {
                return valueList.get(i);
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (int i = 0; i < keyList.size(); i++) {
            if (key == keyList.get(i)) {
                valueList.remove(i);
                keyList.remove(i);
            }
        }
    }
}
