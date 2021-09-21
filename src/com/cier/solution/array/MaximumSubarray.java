package com.cier.solution.array;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int last = 0;
            for (int j = i; j < nums.length; j++){
                int temp = last + nums[j];
                if (max < temp){
                    max = temp;
                }
                last = temp;
            }
        }
        return max;
    }
    // author url :https://leetcode.com/problems/maximum-subarray/discuss/211809/An-easy-java-solution
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (nums[i] > currentSum){
                currentSum = nums[i];
            }
            if (max < currentSum){
                max = currentSum;
            }
        }
        return max;
    }

    /**
     * 暴力的滑动窗口-超时
     * @param array
     * @return
     */
    public int maxSubArray2(int[] array) {
        int windowSize = 1;
        int max = array[0];
        while (windowSize <= array.length) {
            for (int i = 0; i <= array.length - windowSize; i++) {
                int sum = 0;
                for (int j = i; j < i + windowSize ; j++) {
                    sum += array[j];
                }
                max = Math.max(sum, max);
            }
            windowSize++;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-5,6,3};
        MaximumSubarray subarray = new MaximumSubarray();
        System.out.println(subarray.maxSubArray2(nums));
        System.out.println("end");
    }
}
