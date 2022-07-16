package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/longest-common-subsequence/
public class Problem76_LC1143_LongestCommonSubSequence {

    static int longestCommonSubsequence(String text1, String text2) {
        //trivial cases
        if (text1.equals(text2)) return text1.length();
        if (text1.contains(text2)) return text2.length();
        if (text2.contains(text1)) return text1.length();

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int row = text1.length() - 1; row >= 0; row--) {
            for (int col = text2.length() - 1; col >= 0; col--) {
                if(text1.charAt(row) == text2.charAt(col)){
                    dp[row][col] = 1 + dp[row+1][col+1];
                } else {
                    dp[row][col] = Math.max(dp[row+1][col], dp[row][col+1]);
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        assertThat(longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
        assertThat(longestCommonSubsequence("abc", "abc")).isEqualTo(3);

    }
}
