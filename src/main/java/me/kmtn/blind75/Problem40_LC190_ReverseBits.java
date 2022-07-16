package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/reverse-bits/
public class Problem40_LC190_ReverseBits {

    static int reverseBits(int n) {
        int res = 0;
        for(int i=1; i<=32; i++){
            int val = (n >> 32 - i-1) & 1;
            res |= val << i;
        }
       return res;
    }

    public static void main(String[] args) {
        assertThat(reverseBits(43261596)).isEqualTo(964176192);
    }
}
