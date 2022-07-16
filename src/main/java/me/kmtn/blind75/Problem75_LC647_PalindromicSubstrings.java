package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/palindromic-substrings/
public class Problem75_LC647_PalindromicSubstrings {

    static int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int l = i;
            int r = i;
            //odd palindrome
            while(l >=0 && r <s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    count++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            l=i;
            r=i+1;
            //even palindrome
            while(l >=0 && r <s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    count++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }

        }
        return count;
    }


    public static void main(String[] args) {
        assertThat(countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings("aaa")).isEqualTo(6);

    }
}
