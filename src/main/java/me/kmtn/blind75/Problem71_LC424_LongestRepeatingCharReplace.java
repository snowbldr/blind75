package me.kmtn.blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class Problem71_LC424_LongestRepeatingCharReplace {

    //sliding window
    static int characterReplacement(String s, int k) {
        if (s.length() <= 1 || s.length() <= k) return s.length();
        Map<Character, Integer> counts = new HashMap<>();
        int l = 0;
        int max = k;
        int maxCount = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            counts.compute(c, (key, v) -> v == null ? 1 : v + 1);
            maxCount = Math.max(maxCount, counts.get(c));
            //while we need too many replacements, shrink the window
            while ((r - l) + 1 - maxCount > k) {
                counts.computeIfPresent(s.charAt(l), (key, v) -> v - 1);
                l++;
            }
            max = Math.max(max, (r - l) + 1);
        }
        return max;
    }

    //wayyyy too slow
    static int characterReplacementDFS(String s, int k) {
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        if (chars.size() == 1) return s.length();
        int maxRun = 0;
        for (Character c : chars) {
            maxRun = Math.max(maxRun, dfs(s, c, k));
        }

        return maxRun;
    }

    static int dfs(String s, Character c, int k) {
        int maxRun = 0;
        if (k > 0) {
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                if (s.charAt(i) != c) {
                    sb.setCharAt(i, c);
                    maxRun = Math.max(maxRun, dfs(sb.toString(), c, k - 1));
                }
            }
        }
        return Math.max(maxRun, longestRepeatingSequence(s, c));
    }

    static int longestRepeatingSequence(String s, Character c) {
        int maxRun = 1;
        int run = 1;
        for (int i = s.indexOf(c) + 1; i < s.length(); i++) {
            char next = s.charAt(i);
            if (next == c) {
                run++;
                maxRun = Math.max(maxRun, run);
            } else {
                run = 0;
            }
        }
        return maxRun;
    }


    public static void main(String[] args) {
        assertThat(characterReplacement("AABABBA", 1)).isEqualTo(4);
        assertThat(characterReplacement("ABAB", 2)).isEqualTo(4);
        assertThat(characterReplacement("AAAA", 2)).isEqualTo(4);
        assertThat(characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4)).isEqualTo(7);
    }
}
