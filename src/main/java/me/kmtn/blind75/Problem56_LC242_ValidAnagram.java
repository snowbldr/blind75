package me.kmtn.blind75;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/valid-anagram/
public class Problem56_LC242_ValidAnagram {

    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> count1 = countChars(s);
        Map<Character, Integer> count2 = countChars(t);
        if(count1.size() != count2.size()) return false;
        return count1.equals(count2);
    }

    static Map<Character, Integer> countChars(String s){
        Map<Character, Integer> counts = new HashMap<>();
        for(char c : s.toCharArray()){
            counts.compute(c, (k, v) -> v == null ? 1 : v+1);
        }
        return counts;
    }

    public static void main(String[] args) {
       assertThat(isAnagram("anagram", "nagaram")).isTrue();
    }
}
