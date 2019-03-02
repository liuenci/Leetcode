package com.cier.solution.array;
// https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {
    // [0,1,0,3,12]
    public void moveZeroes(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[flag] = nums[i];
                flag++;
            }
        }
        for (int i = flag; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
