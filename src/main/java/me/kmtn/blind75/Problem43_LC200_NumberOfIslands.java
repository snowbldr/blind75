package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/number-of-islands/
public class Problem43_LC200_NumberOfIslands {

    static int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    visitIsland(row, col, grid);
                    count++;
                }
            }
        }
        return count;
    }

    static void visitIsland(int row, int col, char[][] grid) {
        grid[row][col] = 'x';
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            visitIsland(row - 1, col, grid);
        }
        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            visitIsland(row + 1, col, grid);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            visitIsland(row, col - 1, grid);
        }
        if (col + 1 < grid[row].length && grid[row][col + 1] == '1') {
            visitIsland(row, col + 1, grid);
        }
    }

    public static void main(String[] args) {
        assertThat(numIslands(Util.twoDCharArrayFromString("[[\"1\",\"1\",\"1\"],[\"0\",\"1\",\"0\"],[\"1\",\"1\",\"1\"]]"))).isEqualTo(1);
        assertThat(numIslands(Util.twoDCharArrayFromString("[\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]"))).isEqualTo(3);
        assertThat(numIslands(Util.twoDCharArrayFromString("[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]"))).isEqualTo(1);
    }
}
