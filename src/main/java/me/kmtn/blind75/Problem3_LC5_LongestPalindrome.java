package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/longest-palindromic-substring/
public class Problem3_LC5_LongestPalindrome {
    static public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //odd palindrome length
            int odd = longestPalindromeLength(i, i, s);
            //even palindrome length
            int even = longestPalindromeLength(i, i + 1, s);
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int longestPalindromeLength(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        assertThat(longestPalindrome("babad")).isEqualTo("bab");
        assertThat(longestPalindrome("cbbd")).isEqualTo("bb");
    }
}
