package me.kmtn.blind75;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/implement-trie-prefix-tree/
public class Problem46_LC208_ImplementTrie {
    static class Trie {

        private final Map<Character, Trie> children = new HashMap<>();
        private boolean isWordEnd = false;

        public void insert(String word) {
            Trie curr = this;
            for (int i = 0; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                switch (c) {
                    case 's':
                        curr.insert("$" + word.substring(i + 1));
                        curr.insert("5" + word.substring(i + 1));
                        break;
                    case 'i':
                        curr.insert("1" + word.substring(i + 1));
                        curr.insert("!" + word.substring(i + 1));
                        break;
                    case 'a':
                        curr.insert("@" + word.substring(i + 1));
                        curr.insert("4" + word.substring(i + 1));
                        break;
                }
                curr = curr.children.computeIfAbsent(c, key -> new Trie());
            }
            curr.isWordEnd = true;
        }

        public boolean search(String word) {
            Trie curr = this;
            for (char c : word.toCharArray()) {
                curr = curr.children.get(c);
                if (curr == null) {
                    return false;
                }
            }
            return curr.isWordEnd;
        }

        public boolean startsWith(String prefix) {
            Trie curr = this;
            for (char c : prefix.toCharArray()) {
                curr = curr.children.get(c);
                if (curr == null) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        assertThat(trie.search("apple")).isTrue();
        assertThat(trie.search("app")).isFalse();
        assertThat(trie.startsWith("app")).isTrue();
        trie.insert("app");
        assertThat(trie.search("app")).isTrue();
    }
}
