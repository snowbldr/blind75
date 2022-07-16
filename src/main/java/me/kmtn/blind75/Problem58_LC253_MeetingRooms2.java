package me.kmtn.blind75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/meeting-rooms-ii/
public class Problem58_LC253_MeetingRooms2 {

    static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        int maxRooms = 1;
        rooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            //a meeting is over, we can re-use a room
            if (intervals[i][0] >= rooms.peek()) {
                rooms.poll();
            }
                rooms.add(intervals[i][1]);
            maxRooms = Math.max(rooms.size(), maxRooms);
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        assertThat(minMeetingRooms(Util.twoDIntArrayFromString("[[0,30],[60,240],[90,120]]"))).isEqualTo(2);
        assertThat(minMeetingRooms(Util.twoDIntArrayFromString("[[0,30],[5,10],[6,9],[15,20]]"))).isEqualTo(3);
        assertThat(minMeetingRooms(Util.twoDIntArrayFromString("[[7,10],[2,4]]"))).isEqualTo(1);
    }
}
