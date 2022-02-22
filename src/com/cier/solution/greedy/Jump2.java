package com.cier.solution.greedy;

/**
 * 跳跃游戏2
 * @author liuenci
 */
public class Jump2 {

    /**
     * 贪心思路
     * 遍历数组，每次算出当前位置上能走的最大步数 + 每个步数到达的位置中能到达的最大步数，每次取大值。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        // 最短跳跃次数
        int step = 0;
        // 当前需要跳跃的步长
        int localStep = 0;
        // 贪心步数，= 步长范围内的最大步数，每一步都求最大
        int maxStep = 0;
        for (int i = 0; i < nums.length - 1; i = i + localStep) {
            int stepLength = nums[i];
            // 如果当前位置加上本身的步长就能够超过整个数组的长度，则将本次需要执行的步长设置为当前位置的长度即可
            if (i + stepLength + 1 < nums.length) {
                System.out.println("当前位置" + i + ",能跳跃的最大步数为" + stepLength + ",跳跃范围" + i + "~" + (i + stepLength));
                maxStep = 0;
                for (int j = i; j <= i + stepLength && j < nums.length - 1; j++) {
                    if (j - i + nums[j] > maxStep) {
                        maxStep = j - i + nums[j];
                        localStep = j - i;
                    }
                }
            } else {
                localStep = stepLength;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        Jump2 jump2 = new Jump2();
        System.out.println(jump2.jump(new int[]{2,3,1,1,4}));
    }
}
