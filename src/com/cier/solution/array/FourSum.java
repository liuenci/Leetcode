package com.cier.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++){
            // 因为i=0这个元素会直接往下执行
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (i + 3 <= n - 1) {
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
            }
            if (i < n - 3) {
                if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
            }
            for (int j = i + 1; j < n; j++) {
                // 因为j=i+1这个元素会直接往下执行
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int tmp = nums[i] + nums[j] + nums[l] + nums[r];
                    if (tmp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }else if (tmp > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
