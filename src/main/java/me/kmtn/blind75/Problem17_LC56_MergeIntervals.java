package me.kmtn.blind75;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/merge-intervals/
public class Problem17_LC56_MergeIntervals {
    static int[][] merge(int[][] intervals) {
        int[][] temp = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        temp[0] = intervals[0];
        int curr = 0;
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] <= temp[curr][1]){
                if(temp[curr][1] < intervals[i][1]){
                    temp[curr][1] = intervals[i][1];
                }
            } else {
                temp[++curr] = intervals[i];
            }
        }
        int[][] result = new int[curr+1][2];
        System.arraycopy(temp, 0, result, 0, curr + 1);
        return result;
    }

    public static void main(String[] args) {
        assertThat(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
                .isEqualTo(new int[][]{{1, 6}, {8, 10}, {15, 18}});
        assertThat(merge(new int[][]{{1,4}, {0,4}})).isEqualTo(new int[][]{{0,4}});
    }
}
