package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class Problem10_LC33_SearchRotatedArray {
    static int search(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int left = 0, right = nums.length - 1, mid = right / 2;
        while (left <= right) {
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[left]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            mid = (right + left) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 1)).isEqualTo(7);
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 2)).isEqualTo(8);
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 5)).isEqualTo(1);
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}, 7)).isEqualTo(3);
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 4)).isEqualTo(0);
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 3)).isEqualTo(9);
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}, 4)).isEqualTo(0);
        assertThat(search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}, 2)).isEqualTo(8);
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)).isEqualTo(-1);
        assertThat(search(new int[]{1}, 0)).isEqualTo(-1);
        assertThat(search(new int[]{1}, 1)).isEqualTo(0);
        assertThat(search(new int[0], 0)).isEqualTo(-1);
    }
}
