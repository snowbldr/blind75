package me.kmtn.blind75;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/contains-duplicate/
public class Problem50_LC217_ContainsDuplicate {

    static boolean containsDuplicate(int[] nums)  {
        Set<Integer> unique = new HashSet<>();
        for(int n:nums){
            unique.add(n);
        }
        return unique.size() != nums.length;
    }

    public static void main(String[] args) {
        assertThat(containsDuplicate(new int[]{1,2,3,1})).isTrue();
    }
}
