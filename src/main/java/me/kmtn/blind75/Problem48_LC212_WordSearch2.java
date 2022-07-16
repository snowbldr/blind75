package me.kmtn.blind75;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/word-search-ii/
public class Problem48_LC212_WordSearch2 {

    static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        String word = null;
        void add(String word) {
            Trie curr = this;
            for(char c : word.toCharArray()){
                curr = curr.children.computeIfAbsent(c, k -> new Trie());
            }
            curr.word = word;
        }
    }

    static List<String> findWords(char[][] board, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> result = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (trie.children.containsKey(board[row][col])) {
                    char[][] boardCopy = Arrays.copyOf(board, board.length);
                    for (int i = 0; i < board.length; i++) {
                        boardCopy[i] = Arrays.copyOf(board[i], board[i].length);
                    }
                    backTrack(row, col, boardCopy, trie, result);
                }
            }
        }

        return result.stream().toList();
    }

    static void backTrack(int row, int col, char[][] board, Trie parent, Set<String> result) {
        if (parent == null) {
            return;
        }
        char letter = board[row][col];
        if(letter == '-'){
            return;
        }
        Trie trie = parent.children.get(letter);
        if(trie.word != null){
            result.add(trie.word);
            trie.word = null;
        }
        board[row][col] = '-';
        if (col > 0 && trie.children.containsKey(board[row][col - 1])) {
            backTrack(row, col - 1, board, trie, result);
        }
        if (col + 1 < board[row].length && trie.children.containsKey(board[row][col + 1])) {
            backTrack(row, col + 1, board, trie, result);
        }
        if (row > 0 && trie.children.containsKey(board[row - 1][col])) {
            backTrack(row - 1, col, board, trie, result);
        }
        if (row + 1 < board.length && trie.children.containsKey(board[row + 1][col])) {
            backTrack(row + 1, col, board, trie, result);
        }
        board[row][col] = letter;

        if(trie.children.isEmpty()){
            parent.children.remove(letter);
        }
    }

    public static void main(String[] args) {
        assertThat(findWords(Util.twoDCharArrayFromString("[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]"),
                Util.stringArray("oate")))
                .isEqualTo(List.of("oate"));
        assertThat(findWords(Util.twoDCharArrayFromString("[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]"),
                Util.stringArray("oath", "pea", "eat", "rain", "oathi", "oathk", "oathf", "oate", "oathii", "oathfi", "oathfii")))
                .isEqualTo(List.of("oath", "oathk", "oathf", "oathfi", "oathfii", "oathi", "oathii", "oate", "eat"));
        assertThat(findWords(Util.twoDCharArrayFromString("[[\"o\",\"a\",\"b\",\"n\"],[\"o\",\"t\",\"a\",\"e\"],[\"a\",\"h\",\"k\",\"r\"],[\"a\",\"f\",\"l\",\"v\"]]"), Util.stringArray("oa", "oaa"))).isEqualTo(List.of("oa", "oaa"));
        assertThat(findWords(Util.twoDCharArrayFromString("[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]"), Util.stringArray("oath", "pea", "eat", "rain"))).isEqualTo(List.of("oath", "eat"));

    }
}
