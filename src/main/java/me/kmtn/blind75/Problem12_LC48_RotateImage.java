package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/rotate-image/
public class Problem12_LC48_RotateImage {
    static void rotate(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = right;
        // 0,0 0,1 0,2 0,3
        // 1,0 1,1 1,2 1,3
        // 2,0 2,1 2,2 2,3
        // 3,0 3,1 3,2 3,3
        while(left < right) {
            //4x4
            //left = 0, right = 3
            //i = 3 - 0
            for(int i = 0; i<right-left; i++){
                //i = 1
                //l: 1, r: 2, t: 1, b: 3
                int l = left+i, r = right-i, t = top + i, b = bottom - i;
                int last = matrix[top][l];
                //0,0 -> 3,0
                //0,1 -> 2,0
                //0,2 -> 1,0
                matrix[top][l] = matrix[b][left];
                //3,0 -> 3,3
                //2,0 -> 3,2
                //1,0 -> 3,1
                matrix[b][left] = matrix[bottom][r];
                //3,3 -> 0,3
                //3,2 -> 1,3
                //3,1 -> 2,3
                matrix[bottom][r] = matrix[t][right];
                //0,3 -> 0,0
                //1,3 -> 0,1
                //2,3 -> 0,2
                matrix[t][right] = last;
            }
            right--;
            left++;
            bottom--;
            top++;
        }
    }

    public static void main(String[] args) {
        int[][] img = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(img);
        assertThat(img).isEqualTo(new int[][]{{15,13,2,5}, {14,3,4,1}, {12,6,8,9}, {16,7,10,11}});
    }
}
