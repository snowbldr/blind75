package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/word-search/
public class Problem23_LC79_WordSearch {

    static boolean exist(char[][] board, String word) {
        //find start positions
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[i].length];
                    visited[i][j] = true;
                    if(findWord(1, i, j, visited, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean findWord(int nextCharIndex, int i, int j, boolean[][] visited, char[][] board, String word) {
        if(nextCharIndex == word.length()){
            return true;
        }
        //go down
        if(i<board.length - 1){
            if(visit(nextCharIndex, i+1, j, visited, board, word)) {
                return true;
            }
        }
        if(i > 0){
            if(visit(nextCharIndex, i-1, j, visited, board, word)) {
                return true;
            }
        }
        if(j > 0){
            if(visit(nextCharIndex, i, j-1, visited, board, word)) {
                return true;
            }
        }

        if(j < board[i].length - 1){
            if(visit(nextCharIndex, i, j + 1, visited, board, word)){
                return true;
            }
        }

        return false;
    }

    static boolean visit(int nextCharIndex, int i, int j, boolean[][] visited, char[][] board, String word) {
        if(!visited[i][j] && board[i][j] ==  word.charAt(nextCharIndex)) {
            visited[i][j] = true;
            if(findWord(nextCharIndex + 1, i, j, visited, board, word)){
                return true;
            } else {
                visited[i][j] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        assertThat(exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}}, "ABCESEEEFS")).isTrue();
        assertThat(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")).isTrue();
        assertThat(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE")).isTrue();
        assertThat(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB")).isFalse();
    }
}
