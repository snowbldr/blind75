package me.kmtn.blind75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class Problem1_LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (seen.containsKey(compliment)) {
                return new int[]{i, seen.get(compliment)};
            }
            seen.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
