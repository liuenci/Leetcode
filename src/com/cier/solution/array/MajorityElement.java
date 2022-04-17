package com.cier.solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/majority-element/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int key = 0;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                key = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return key;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        // 1 2 2 3 4 5 6 7
        return nums[(nums.length - 1) /2 ];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4,5,6,7,8};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement2(nums);
        System.out.println("end");
    }
}
