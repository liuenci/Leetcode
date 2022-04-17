package com.cier.solution.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode-cn.com/problems/single-number/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumbe2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        return set.iterator().next();
    }

    /**
     * 异或
     * @param nums
     * @return
     */
    public int singleNumbe3(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,3};
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumbe3(nums);
        // 4 = 100
        // 3 = 010 4^3=110
        // 3 = 010 7^3=100
        System.out.println(nums);
    }
}
