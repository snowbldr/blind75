package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/missing-number/
public class Problem60_LC268_MissingNumber {

    static int missingNumber(int[] nums) {
        Integer[] ns = new Integer[nums.length + 1];
        for (int n : nums) {
            ns[n] = n;
        }
        for (int i = 0; i < ns.length; i++) {
            if (ns[i] == null) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        assertThat(missingNumber(Util.intArray(3, 0, 1))).isEqualTo(2);
        assertThat(missingNumber(Util.intArray(0, 1))).isEqualTo(2);
        assertThat(missingNumber(Util.intArray(9, 6, 4, 2, 3, 5, 7, 0, 1))).isEqualTo(8);
    }
}
