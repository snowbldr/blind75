package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/container-with-most-water/
public class Problem4_LC11_MostWater {
    static public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[l] > height[r]){
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        assertThat(maxArea(new int[]{1,8,6,2,5,4,8,3,7})).isEqualTo(49);
        assertThat(maxArea(new int[]{2,3,4,5,18,17,6})).isEqualTo(17);
        assertThat(maxArea(new int[]{1,1})).isEqualTo(1);
    }
}
