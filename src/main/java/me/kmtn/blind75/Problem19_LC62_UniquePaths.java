package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/unique-paths/
public class Problem19_LC62_UniquePaths {
    static int uniquePaths(int height, int width) {
        int[][] pathCounts = new int[height][width];
        for(int i=0; i<height; i++){
            pathCounts[i][0] = 1;
        }
        for(int i=0; i<width; i++){
            pathCounts[0][i] = 1;
        }
        for(int y=1; y<height; y++){
            for(int x=1; x< width; x++){
                pathCounts[y][x] = pathCounts[y-1][x] + pathCounts[y][x-1];
            }
        }
        return pathCounts[height-1][width-1];
    }

    static void findPath(int x, int y, int height, int width, int[] pathCounter){
        if(y == height -1 && x == width - 1) {
            pathCounter[0]++;
            return;
        }

        if(x < width){
            findPath(x+1, y, height, width, pathCounter);
        }
        if(y < height) {
            findPath(x, y+1, height, width, pathCounter);
        }
    }

    public static void main(String[] args) {
        assertThat(uniquePaths(3,7)).isEqualTo(28);
        assertThat(uniquePaths(3,2)).isEqualTo(3);
    }
}
