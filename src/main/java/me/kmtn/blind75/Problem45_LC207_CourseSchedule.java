package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/course-schedule/
public class Problem45_LC207_CourseSchedule {


    static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> dependencies = new ArrayList<>();
        Set<Integer> finishable = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            dependencies.add(new ArrayList<>());
        }
        for(int[] prereq : prerequisites) {
            dependencies.get(prereq[0]).add(prereq[1]);
        }
        for(int i=0; i<numCourses; i++){
            if(!canFinish(i, dependencies, finishable, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    static boolean canFinish(int i, List<List<Integer>> dependencies, Set<Integer> finishable, Set<Integer> visited) {
        if(finishable.contains(i)){
            return true;
        }
        if(visited.contains(i)){
            return false;
        }
        visited.add(i);
        for(int d : dependencies.get(i)){
            if(!canFinish(d, dependencies, finishable, visited)){
                return false;
            }
        }
        finishable.add(i);
        return true;
    }

    public static void main(String[] args) {
        assertThat(canFinish(5, Util.twoDIntArrayFromString("[[1,4],[2,4],[3,1],[3,2]]"))).isTrue();
        assertThat(canFinish(2, Util.twoDIntArrayFromString("[[1,0],[0,1]]"))).isFalse();
    }
}
