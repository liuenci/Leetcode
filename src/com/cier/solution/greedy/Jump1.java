package com.cier.solution.greedy;

/**
 * @author liuenci
 */
public class Jump1 {

    /**
     * 遍历数组，理论上会遍历两轮，第一轮是遍历原始的 nums，第二轮根据所处的位置的高度尝试往前走
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
//        boolean flag = false;
//        int maxStep = 0;
//        int localStep = 0;
//        for (int i = 0; i < nums.length; i = i + localStep) {
//            maxStep = nums[i];
//            int height = nums[i];
//            if (localStep == 0) {
//                break;
//            }
//            for (int j = i; j <= i + height && ; j++) {
//                // 当前所处位置 + 所处位置的索引判断是否可以到达最后一个点，还是贪心算能到达的最远距离
//                if (j - i + nums[i] > maxStep) {
//                    maxStep = j - i + nums[j];
//                    localStep = j - i;
//                }
//            }
//        }
//        return flag;
        return true;
    }
}
