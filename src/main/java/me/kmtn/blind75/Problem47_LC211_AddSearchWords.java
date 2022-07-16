package me.kmtn.blind75;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class Problem47_LC211_AddSearchWords {
    static class WordDictionary {

        Map<Character, WordDictionary> children = new HashMap<>();

        boolean isEnd = false;

        public WordDictionary() {}

        public void addWord(String word) {
            WordDictionary curr = this;
            for(char c : word.toCharArray()){
                curr = curr.children.computeIfAbsent(c, k-> new WordDictionary());
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            return search(word.toCharArray(), 0);
        }

        private boolean search(char[] chars, int i){
            if(i == chars.length){
                return isEnd;
            }
            if(chars[i] == '.'){
                for(WordDictionary wd : children.values()){
                    if(wd.search(chars, i+1)){
                        return true;
                    }
                }
            } else {
                if(children.containsKey(chars[i])){
                    return children.get(chars[i]).search(chars, i+1);
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        assertThat(wordDictionary.search("a")).isFalse();
        assertThat(wordDictionary.search(".at")).isFalse();
        wordDictionary.addWord("bat");
        assertThat(wordDictionary.search(".at")).isTrue();
        assertThat(wordDictionary.search("an.")).isTrue();
        assertThat(wordDictionary.search("a.d.")).isFalse();
        assertThat(wordDictionary.search("b.")).isFalse();
        assertThat(wordDictionary.search("a.d")).isTrue();
        assertThat(wordDictionary.search(".")).isFalse();

    }
}
