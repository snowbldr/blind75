package me.kmtn.blind75;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Problem02_LC3_LongestSubstring {
    static public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int longestSubstring = 0;
        int left = 0;
        for(int right=0; right < s.length(); right++){
            char c = s.charAt(right);
            while(chars.contains(c)){
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(c);
            longestSubstring = Math.max(longestSubstring, right - left + 1);
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("bbbbbbbb")).isEqualTo(1);
        assertThat(lengthOfLongestSubstring("asdfjldkjasdfghtyuiop")).isEqualTo(14);
    }
}
