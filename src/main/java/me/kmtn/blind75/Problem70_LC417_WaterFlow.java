package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/pacific-atlantic-water-flow/
public class Problem70_LC417_WaterFlow {

    static List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0) return Collections.emptyList();
        result = new ArrayList<>();
        toPacific = new boolean[heights.length][heights[0].length];
        toAtlantic = new boolean[heights.length][heights[0].length];
        for (int row = 0; row < heights.length; row++) {
            dfs(row, 0, heights, toPacific);
            dfs(row, heights[0].length - 1, heights, toAtlantic);
        }
        for (int col = 0; col < heights[0].length; col++) {
            dfs(0, col, heights, toPacific);
            dfs(heights.length - 1, col, heights, toAtlantic);
        }
        return result;
    }
    private static List<List<Integer>> result;
    private static boolean[][] toPacific;
    private static boolean[][] toAtlantic;
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    static void dfs(int row, int col, int[][] heights, boolean[][] reachable) {
        if (reachable[row][col]) return;
        reachable[row][col] = true;
        if(toPacific[row][col] && toAtlantic[row][col]){
            result.add(Arrays.asList(row, col));
        }
        for (int[] dir : DIRECTIONS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextRow >= heights.length || nextCol < 0 || nextCol >= heights[0].length) continue;
            if (heights[nextRow][nextCol] < heights[row][col]) continue;
            if (reachable[nextRow][nextCol]) continue;

            dfs(nextRow, nextCol, heights, reachable);
        }
    }

    public static void main(String[] args) {
        assertThat(pacificAtlantic(Util.twoDIntArrayFromString("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]")))
                .isEqualTo(List.of(List.of(0, 4), List.of(1, 3), List.of(1, 4), List.of(2, 2), List.of(3, 0), List.of(3, 1), List.of(4, 0)));
    }
}
