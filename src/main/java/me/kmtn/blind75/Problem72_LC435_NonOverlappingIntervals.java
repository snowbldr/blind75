package me.kmtn.blind75;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/non-overlapping-intervals/
public class Problem72_LC435_NonOverlappingIntervals {

    //sliding window
    static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] prev = intervals[0];
        int removed = 0;
        for(int i=1; i<intervals.length; i++){
            int[] next = intervals[i];
            if(prev[1] > next[0]){
                //overlapping, save interval with shorter end
                if(prev[1] > next[1]){
                    prev = next;
                }
                removed++;
            } else {
                prev = next;
            }
        }
        return removed;
    }

    public static void main(String[] args) {
        assertThat(eraseOverlapIntervals(Util.twoDIntArrayFromString("[[1,2],[1,2],[1,2]]"))).isEqualTo(2);
        assertThat(eraseOverlapIntervals(Util.twoDIntArrayFromString("[[1,2],[2,3],[3,4],[1,3]]"))).isEqualTo(1);
        assertThat(eraseOverlapIntervals(Util.twoDIntArrayFromString("[[1,2],[2,3]]"))).isEqualTo(0);
    }
}
