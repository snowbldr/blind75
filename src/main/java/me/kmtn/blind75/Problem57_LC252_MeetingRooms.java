package me.kmtn.blind75;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/meeting-rooms/
public class Problem57_LC252_MeetingRooms {

    static boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        assertThat(canAttendMeetings(Util.twoDIntArrayFromString("[[0,30],[60,240],[90,120]]"))).isFalse();
       assertThat(canAttendMeetings(Util.twoDIntArrayFromString("[[0,30],[5,10],[15,20]]"))).isFalse();
        assertThat(canAttendMeetings(Util.twoDIntArrayFromString("[[7,10],[2,4]]"))).isTrue();
    }
}
