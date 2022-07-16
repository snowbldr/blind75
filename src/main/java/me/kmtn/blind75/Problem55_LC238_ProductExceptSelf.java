package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/product-of-array-except-self/solution/
public class Problem55_LC238_ProductExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int rightTotal = 1;
        for(int i=nums.length - 1; i>=0; i--){
            ans[i] = ans[i] * rightTotal;
            rightTotal *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        assertThat(productExceptSelf(Util.intArray(1,2,3,4))).isEqualTo(Util.intArray(24,12,8,6));
        assertThat(productExceptSelf(Util.intArray(-1,1,0,-3,3))).isEqualTo(Util.intArray(0,0,9,0,0));
    }
}
