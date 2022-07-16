package me.kmtn.blind75;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class Problem64_LC300_LongestIncreasingSubsequence {
    static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int longest = 1;
        for(int i=nums.length-2; i>=0; i--){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    longest = Math.max(dp[i], longest);
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        assertThat(lengthOfLIS(Util.intArray(10,9,2,5,3,7,101,18))).isEqualTo(4);
        assertThat(lengthOfLIS(Util.intArray(0,1,0,3,2,3))).isEqualTo(4);
        assertThat(lengthOfLIS(Util.intArray(7,7,7,7,7,7,7))).isEqualTo(1);

    }
}
