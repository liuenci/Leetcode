package com.cier.solution.dp;
// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return max(nums[0], nums[1]);
        }
        int a = nums[0];
        int b = max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = b;
            b = max(a + nums[i], b);
            a = temp;
        }
        return b;
    }

    /**
     * 动态规划
     * 维护一个动态规划数组
     * dp[0] 为数组中的第一个数
     * dp[1] 为数组中的第一个数和第二个数的较大值
     * dp[2] 为数组中的第一个数和第三个数的和以及第二个数的较大值
     * 状态转移方程则为 dp[i] = max(num[i] + dp[i - 2],dp[i - 1])
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int[] array = new int[nums.length];
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        array[0] = nums[0];
        array[1] = max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            array[i] = max(nums[i] + array[i - 2],array[i - 1]);
        }
        return array[n - 1];
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int nums = houseRobber.rob(new int[]{2,7,9,3,1,4,3,5,2,5,2});
        System.out.println("end");
    }
}
