package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/maximum-subarray/
public class Problem14_LC53_MaxSubarray {
    static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        assertThat(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}))
                .isEqualTo(6);
        assertThat(maxSubArray(new int[]{-2,1}))
                .isEqualTo(1);
        assertThat(maxSubArray(new int[]{-3,-2,-4}))
                .isEqualTo(-2);
    }
}
