package me.kmtn.blind75;

import static me.kmtn.blind75.Util.intArrayFromString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/maximum-product-subarray/
public class Problem38_LC152_MaxProductSubarray {

    static int maxProduct(int[] nums) {
        Integer res = null;
        for (int i : nums) {
            res = Math.max(res == null ? Integer.MIN_VALUE : res, i);
        }
        int max = 1;
        int min = 1;

        for (int n : nums) {
            int tmp = n * max;
            max = Math.max(Math.max(tmp, n * min), n);
            min = Math.min(Math.min(tmp, n * min), n);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        assertThat(maxProduct(intArrayFromString("[-2]"))).isEqualTo(-2);
        assertThat(maxProduct(intArrayFromString("[0,2]"))).isEqualTo(2);
        assertThat(maxProduct(intArrayFromString("[-2,0,-1]"))).isEqualTo(0);
        assertThat(maxProduct(intArrayFromString("[2,3,-2,4]"))).isEqualTo(6);
    }
}
