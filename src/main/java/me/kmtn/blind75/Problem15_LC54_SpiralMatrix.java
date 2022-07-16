package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/spiral-matrix/
public class Problem15_LC54_SpiralMatrix {
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (bottom >= top && right >= left) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right - 1; i > left && bottom > top; i--) {
                result.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top && right > left; i--) {
                result.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        assertThat(spiralOrder(new int[][]{{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}}))
                .isEqualTo(List.of(1,2,3,4,5,6,7,8,9,10));
        assertThat(spiralOrder(new int[][]{{6}, {9}, {7}}))
                .isEqualTo(List.of(6, 9, 7));
        assertThat(spiralOrder(new int[][]{{6, 9, 7}}))
                .isEqualTo(List.of(6, 9, 7));
        assertThat(spiralOrder(new int[][]{{3}, {2}}))
                .isEqualTo(List.of(3, 2));
        assertThat(spiralOrder(new int[][]{{0}}))
                .isEqualTo(List.of(0));
        assertThat(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}))
                .isEqualTo(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5));
        assertThat(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}))
                .isEqualTo(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
    }
}
