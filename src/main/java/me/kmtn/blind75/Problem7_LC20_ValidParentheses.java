package me.kmtn.blind75;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/valid-parentheses/
public class Problem7_LC20_ValidParentheses {
    static Set<Character> openers = new HashSet<>();
    static Map<Character, Character> closers = new HashMap<>();
    static {
        openers.add('(');
        openers.add('{');
        openers.add('[');
        closers.put(')', '(');
        closers.put('}', '{');
        closers.put(']', '[');

    }
    static boolean isValid(String s) {
        Stack<Character> openBrackets = new Stack<>();
        for (char c : s.toCharArray()) {
            if (openers.contains(c)) {
                openBrackets.push(c);
            } else {
                if(closers.containsKey(c)){
                    if(!openBrackets.isEmpty() && openBrackets.peek() == closers.get(c)){
                        openBrackets.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return openBrackets.isEmpty();
    }

    public static void main(String[] args) {
        assertThat(isValid("()")).isTrue();
        assertThat(isValid("(){}[]")).isTrue();
        assertThat(isValid("((())){{{}}}[[[]]]")).isTrue();
        assertThat(isValid("((({{{[[[]]]}}})))")).isTrue();
        assertThat(isValid("([)]")).isFalse();
        assertThat(isValid("(]")).isFalse();
        assertThat(isValid("(")).isFalse();
        assertThat(isValid(")")).isFalse();
    }
}
