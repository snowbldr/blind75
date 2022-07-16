package me.kmtn.blind75;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/decode-ways/
public class Problem24_LC91_DecodeWays {

    static int numDecodings(String s) {
        Map<Integer, Integer> resultCache = new HashMap<>();
        return countWays(0, s, resultCache);
    }

    static int countWays(int currentLength, String s, Map<Integer, Integer> resultCache) {
        if(currentLength == s.length()){
            return 1;
        } else if(currentLength > s.length()){
            return 0;
        }
        if(resultCache.containsKey(currentLength)){
            return resultCache.get(currentLength);
        }
        int next = Character.getNumericValue(s.charAt(currentLength));
        int ways = 0;
        if(next > 0){
            ways += countWays(currentLength+1, s, resultCache);
        }
        if(currentLength+1 < s.length()){
            int nextNext = Character.getNumericValue(s.charAt(currentLength+1));
            if(next == 1 || (next ==2 && nextNext <= 6)){
                ways += countWays(currentLength+2, s, resultCache);
            }
        }

        resultCache.put(currentLength, ways);
        return ways;
    }

    public static void main(String[] args) {
        assertThat(numDecodings("0000")).isEqualTo(0);
        assertThat(numDecodings("12")).isEqualTo(2);
        assertThat(numDecodings("10203")).isEqualTo(1);
        assertThat(numDecodings("226")).isEqualTo(3);
        assertThat(numDecodings("11111")).isEqualTo(8);
        //1 1 1 1 1
        //1 11 1 1
        //1 1 11 1
        //1 1 1 11
        //1 11 11
        //11 1 1 1
        //11 11 1
        //11 1 11
    }
}
