package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/jump-game/
public class Problem16_LC55_JumpGame {
    static boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for(int i = nums.length - 1; i>=0; i--){
            if(i+nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }

    public static void main(String[] args) {
        assertThat(canJump(new int[]{2,3,1,1,4})).isTrue();
    }
}
