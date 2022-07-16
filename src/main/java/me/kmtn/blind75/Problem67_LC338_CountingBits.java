package me.kmtn.blind75;

//https://leetcode.com/problems/counting-bits/
public class Problem67_LC338_CountingBits {

    static int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0; i<=n; i++){
            res[i] = hammingWeight(i);
        }
        return res;
    }
    static int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            count += (n >> i) & 1;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
