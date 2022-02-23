package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [55] 跳跃游戏
 * @author: liuenci
 * @create: 2022-02-23 22:18
 **/
public class CanJump {
    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2, 0, 0}));
    }

    /**
     * 假设当前位置的值为 3，那么当前位置的后面 3 个位置都能作为起跳点
     * 维护一个当前能跳跃的最大值，如果遍历的时候走到的索引位置大于之前走的最大位置，说明当前位置是不可以到达的
     * 如果整个数组都遍历完了，本身就说明能够跳到最后一个位置中
     * 总体来说还是贪心算法
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxStep) {
                return false;
            }
            maxStep = Math.max(maxStep, i + nums[i]);
        }
        return true;
    }
}
