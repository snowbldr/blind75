package me.kmtn.blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/set-matrix-zeroes/
public class Problem21_LC73_SetMatrixZeroes {

    static void setZeroes(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for(Integer i: zeroRows){
            Arrays.fill(matrix[i], 0);
        }
        for(Integer j: zeroCols){
            for(int i=0; i<matrix.length; i++){
                matrix[i][j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        assertThat(matrix).isEqualTo(new int[][]{{1,0,1},{0,0,0},{1,0,1}});
    }
}
