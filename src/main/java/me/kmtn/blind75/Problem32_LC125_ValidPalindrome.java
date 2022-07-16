package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/valid-palindrome/
public class Problem32_LC125_ValidPalindrome {

    static boolean isPalindrome(String s) {
        String clean = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l,r;
        if(clean.length() % 2 == 0){
            r = clean.length()/2;
            l = r-1;
        } else {
            r = clean.length()/2;
            l = r;
        }
        while(l>=0){
            if(clean.charAt(l) != clean.charAt(r)){
                return false;
            }
            l--;
            r++;
        }
        return true;
    }
    public static void main(String[] args) {
        assertThat(isPalindrome("A man, a plan, a canal: Panama")).isTrue();
        assertThat(isPalindrome("race a car")).isFalse();
    }
}
