package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/insert-interval/
public class Problem18_LC57_InsertInteval {
    static int[][] merge(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int[][] temp = new int[intervals.length+1][2];
        int cur = -1;
        if(newInterval[0] < intervals[0][0]){
            temp[++cur] = newInterval;
        }
        for(int[] interval : intervals){
            //new interval is between intervals with no overlap
            if(cur >= 0 && temp[cur][1] < newInterval[0] && interval[0] > newInterval[1]) {
                temp[++cur] = newInterval;
                temp[++cur] = interval;
            } else
            //non overlapping interval
            if(interval[1] < newInterval[0] || interval[0] > newInterval[1]) {
                temp[++cur] = interval;
            } else {
                if(cur < 0 || temp[cur][1] < newInterval[0]){
                    temp[++cur] = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
                } else {
                    temp[cur][1] = Math.max(interval[1], newInterval[1]);
                }
            }
        }
        if(newInterval[1] > temp[cur][1]){
            temp[++cur] = newInterval;
        }
        int[][] result = new int[cur+1][2];
        System.arraycopy(temp, 0, result, 0, cur + 1);
        return result;
    }

    public static void main(String[] args) {
        assertThat(merge(new int[][]{{3,5},{12,15}}, new int[]{6,6}))
                .isEqualTo(new int[][]{{3,5},{6,6},{12,15}});
        assertThat(merge(new int[][]{{1,3}}, new int[]{4,5}))
                .isEqualTo(new int[][]{{1,3},{4,5}});
        assertThat(merge(new int[][]{{6,7}}, new int[]{4,5}))
                .isEqualTo(new int[][]{{4,5},{6,7}});
        assertThat(merge(new int[][]{{5,7}}, new int[]{5,7}))
                .isEqualTo(new int[][]{{5,7}});
        assertThat(merge(new int[][]{}, new int[]{5,7}))
                .isEqualTo(new int[][]{{5,7}});
        assertThat(merge(new int[][]{{1,3},{6,9}}, new int[]{2,5}))
                .isEqualTo(new int[][]{{1,5},{6,9}});
        assertThat(merge(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}))
                .isEqualTo(new int[][]{{1,2},{3,10},{12,16}});
    }
}
