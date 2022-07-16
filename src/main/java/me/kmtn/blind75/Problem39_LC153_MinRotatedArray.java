package me.kmtn.blind75;

import static me.kmtn.blind75.Util.intArrayFromString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class Problem39_LC153_MinRotatedArray {

    static int findMin(int[] nums) {
        if(nums.length< 1) return 0;
        int left = 0, right = nums.length-1, mid = right / 2;
        while(left <= right && nums[right] < nums[left]){
            if(nums[mid]>= nums[left]){
                left = mid+1;
            } else {
                right = mid;
            }
            mid = left + ((right - left)/2);
        }
        return nums[left];
    }

    public static void main(String[] args) {
        assertThat(findMin(intArrayFromString("[3,4,5,1,2]"))).isEqualTo(1);
        assertThat(findMin(intArrayFromString("[3]"))).isEqualTo(3);
        assertThat(findMin(intArrayFromString("[4,5,1,2,3]"))).isEqualTo(1);
        assertThat(findMin(intArrayFromString("[4,5,6,7,0,1,2]"))).isEqualTo(0);
        assertThat(findMin(intArrayFromString("[11,13,15,17]"))).isEqualTo(11);
    }
}
