package com.cier.solution.array;

import java.util.HashMap;
// https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
