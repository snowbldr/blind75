package me.kmtn.blind75;

import java.util.HashMap;
import java.util.Map;

import static me.kmtn.blind75.Util.intArrayFromString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/house-robber/
public class Problem42_LC198_HouseRobber {

    static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    static int robmemo(int[] nums) {
        Map<Integer, Integer> results = new HashMap<>();
        int max =0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, calcMax(i, nums, results));
        }
       return max;
    }

    static int calcMax(int start, int[] nums, Map<Integer, Integer> results){
        if(results.containsKey(start)){
            return results.get(start);
        }
        if(start > nums.length){
            results.put(start, 0);
            return 0;
        }
        int max = nums[start];
        for(int i=start+2; i<nums.length; i++){
            max = Math.max(max, nums[start] + calcMax(i, nums, results));
        }
        results.put(start, max);
        return max;
    }

    public static void main(String[] args) {
        assertThat(rob(intArrayFromString("[2,7,9,3,1,3,5,1,2,8,11]"))).isEqualTo(12);
        assertThat(rob(intArrayFromString("[1,2,3,1]"))).isEqualTo(4);
        assertThat(rob(intArrayFromString("[2,1,1,2]"))).isEqualTo(4);
    }
}
