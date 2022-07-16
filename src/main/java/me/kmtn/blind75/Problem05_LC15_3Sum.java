package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/3sum/
public class Problem05_LC15_3Sum {
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l=i+1, r = nums.length - 1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum> 0){
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    result.add(asList(nums[i], nums[l], nums[r]));
                    l++;
                    while(nums[l] == nums[l-1] && l<r){
                        l++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        assertThat(threeSum(new int[]{-1, 0, 1, 2, -1, -4})).isEqualTo(asList(asList(-1, -1, 2), asList(-1, 0, 1)));
        assertThat(threeSum(new int[0])).isEqualTo(emptyList());
        assertThat(threeSum(new int[]{0})).isEqualTo(emptyList());
        assertThat(threeSum(new int[]{1, 1, 2, 2, -3, -3, 3, 3, 0, 0})).isEqualTo(asList(asList(-3, 0, 3), asList(-3, 1, 2)));
    }
}
