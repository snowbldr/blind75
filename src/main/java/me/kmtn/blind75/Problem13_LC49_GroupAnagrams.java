package me.kmtn.blind75;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/group-anagrams/
public class Problem13_LC49_GroupAnagrams {
    static  List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return anagrams.values().stream().toList();
    }

    public static void main(String[] args) {
        assertThat(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}))
                .isEqualTo(List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea")));
        assertThat(groupAnagrams(new String[]{""}))
                .isEqualTo(List.of(List.of("")));
        assertThat(groupAnagrams(new String[]{"a"}))
                .isEqualTo(List.of(List.of("a")));
    }
}
