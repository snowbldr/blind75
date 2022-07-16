package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/number-of-1-bits/
public class Problem41_LC191_NumberOf1Bits {

    static int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            count += (n >> i) & 1;
        }
        return count;
    }

    public static void main(String[] args) {
        assertThat(hammingWeight(11)).isEqualTo(3);
        assertThat(hammingWeight(-1)).isEqualTo(32);
    }
}
