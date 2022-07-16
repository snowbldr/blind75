package me.kmtn.blind75;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/climbing-stairs/
public class Problem20_LC70_ClimbingStairs {

    int climbStairs(int n) {
        int one = 0;
        int two = 1;
        for(int i=0; i<=n; i++){
            int tmp = one+two;
            two = one;
            one = tmp;
        }
        return one;
    }
    int findPaths(int n, int position, Map<Integer, Integer> results) {
        if(position > n) return 0;
        if(position == n) return 1;
        if(results.containsKey(position)){
            return results.get(position);
        }
        int result = findPaths(n, position+1, results);
        result += findPaths(n, position+2, results);
        results.put(position, result);
        return result;
    }

    public static void main(String[] args) {
        Problem20_LC70_ClimbingStairs p = new Problem20_LC70_ClimbingStairs();
        assertThat(p.climbStairs(5)).isEqualTo(8);
        assertThat(p.climbStairs(2)).isEqualTo(2);
        assertThat(p.climbStairs(3)).isEqualTo(3);
    }
}
