package com.cier.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    /**
     * 超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 将数组排序
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        // 通过三层循环进行暴力搜索
        for (int i = 0; i < n; i++) {
            // 如果出现相同的值则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                // 如果出现相同的值则跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    // 如果出现相同的值则跳过
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    // 如果三个数相加为 0，则是目标值集合
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ret.add(temp);
                    }
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        // 将数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 如果出现相同的值则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // l 和 r 分别代表左右两个指针，实际上是双索引法的延申
            int l = i + 1;
            int r = n - 1;
            // 如果 l < r 说明还可以进行搜索满足条件的三个值
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == 0) {
                    // 如果 temp = 0 说明满足条件，可以添加到集合中
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[l]);
                    tempList.add(nums[r]);
                    ret.add(tempList);
                    // 满足条件就左右两个指针向中间靠拢
                    l++;
                    r--;
                    // 递增的同时要排除重复的值
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    // 递增的同时要排除重复的值
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (temp > 0){
                    // temp > 0 说明需要更小的值，则右指针左移
                    r--;
                } else {
                    // temp < 0 说明需要更大的值，则左指针右移1
                    l++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum.threeSum1(nums);
    }
}
