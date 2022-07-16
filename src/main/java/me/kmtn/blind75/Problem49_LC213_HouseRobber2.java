package me.kmtn.blind75;

import static me.kmtn.blind75.Util.intArrayFromString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/house-robber-ii/
public class Problem49_LC213_HouseRobber2 {

    static int rob(int[] nums) {
        if(nums.length<1) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(doRob(nums, 0, nums.length-2), doRob(nums, 1, nums.length-1));

    }

    static int doRob(int[] nums, int start, int end){
        int length = end - start + 1;
        if(length == 2) return Math.max(nums[start], nums[end]);
        if(length == 3) return Math.max(nums[start+1], nums[start] + nums[start+2]);
        int[] dp = new int[length];

        dp[0] = nums[start];
        dp[1] = Math.max(dp[0], nums[start+1]);
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start+i]);
        }
        return dp[length-1];
    }


    public static void main(String[] args) {
        assertThat(rob(intArrayFromString("[1,3,1,3,100]"))).isEqualTo(103);
        assertThat(rob(intArrayFromString("[200,3,140,20,10]"))).isEqualTo(340);
        assertThat(rob(intArrayFromString("[1,2,3]"))).isEqualTo(3);
        assertThat(rob(intArrayFromString("[2,3,2]"))).isEqualTo(3);
        assertThat(rob(intArrayFromString("[1,2,3,1]"))).isEqualTo(4);
        assertThat(rob(intArrayFromString("[2,1,1,2]"))).isEqualTo(3);
        assertThat(rob(intArrayFromString("[2,7,9,3,1,3,5,1,2,8,11]"))).isEqualTo(28);
    }
}
