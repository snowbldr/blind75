package me.kmtn.blind75;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/alien-dictionary/
public class Problem61_LC269_AlienDictionary {

    static String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for(String word: words){
            for(char c : word.toCharArray()){
                inDegree.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        for(int i=0; i< words.length -1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            for(int j = 0; j< Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    inDegree.compute(word2.charAt(j), (k,v) -> v+1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();
        for(Map.Entry<Character, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }
        while(!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);
            for(Character next : adjList.get(c)) {
                Integer nextDegree = inDegree.compute(next, (k, v) -> v - 1);
                if (nextDegree == 0) {
                    q.add(next);
                }
            }
        }
        if(sb.length() < inDegree.size()) return "";
        return sb.toString();
    }

    static String myAlienOrder(String[] words) {
        Map<Character, Set<Character>> charGraph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        try {
            buildGraph(Arrays.asList(words), 0, charGraph, inDegree);
        } catch (IllegalArgumentException e){
            return "";
        }
        Queue<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }
        //no nodes without dependencies, this is a graph with a cycle
        if (q.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character next = q.poll();
            sb.append(next);
            if (charGraph.containsKey(next)) {
                for (Character c : charGraph.get(next)) {
                    Integer nextDegree = inDegree.compute(c, (k, v) -> v - 1);
                    if (nextDegree == 0) {
                        q.add(c);
                    }
                }
            }
        }
        for(Integer degree : inDegree.values()){
            if(degree != 0){
                return "";
            }
        }
        return sb.toString();
    }

    static void buildGraph(List<String> words, int charIndex, Map<Character, Set<Character>> graph, Map<Character, Integer> inDegree) {
        if (words.size() == 0) return;
        String firstWord = words.get(0);
        if (words.size() == 1 && firstWord.length() > charIndex) {
            for (int i = charIndex; i < firstWord.length(); i++) {
                graph.putIfAbsent(firstWord.charAt(i), new HashSet<>());
                inDegree.putIfAbsent(firstWord.charAt(i), 0);
            }
            return;
        }

        List<String> next = new ArrayList<>();
        Character currentChar = null;
        int lastLength = Integer.MAX_VALUE;
        if (firstWord.length() > charIndex) {
            currentChar = firstWord.charAt(charIndex);
            inDegree.putIfAbsent(currentChar, 0);
            next.add(firstWord);
            lastLength = firstWord.length();
        }

        for (int i = 1; i < words.size(); i++) {
            String word = words.get(i);
            if(charIndex >0 && currentChar != null && word.length()-2 < charIndex && word.charAt(charIndex-1) == firstWord.charAt(charIndex-1) && lastLength > word.length()){
                throw new IllegalArgumentException();
            }
            if (word.length()-1 < charIndex) continue;
            Character nextChar = word.charAt(charIndex);
            inDegree.putIfAbsent(nextChar, 0);
            //collect all the words with the same character, as we can't tell the ordering if the characters are the same
            if (nextChar == currentChar) {
                next.add(word);
            } else {
                if (currentChar != null) {
                    Set<Character> chars = graph.computeIfAbsent(currentChar, k -> new HashSet<>());
                    if(!chars.contains(nextChar)){
                        chars.add(nextChar);
                        inDegree.compute(nextChar, (k, v) -> v == null ? 0 : v + 1);
                    }
                }
                buildGraph(next, charIndex + 1, graph, inDegree);
                next = new ArrayList<>();
                next.add(word);
                currentChar = nextChar;
            }
        }
        buildGraph(next, charIndex + 1, graph, inDegree);
    }

    public static void main(String[] args) {
        assertThat(alienOrder(Util.stringArray("z","x","a","zb","zx"))).isEqualTo("");
        assertThat(alienOrder(Util.stringArray("abc","ab"))).isEqualTo("");
        assertThat(alienOrder(Util.stringArray("ac","ab","zc","zb"))).isEqualTo("aczb");
        assertThat(alienOrder(Util.stringArray("z", "z"))).isEqualTo("z");
        assertThat(alienOrder(Util.stringArray("wrt", "wrtkj"))).isEqualTo("rtwjk");
        assertThat(alienOrder(Util.stringArray("ab", "adc"))).isEqualTo("abcd");
        assertThat(alienOrder(Util.stringArray("zx", "zy"))).isEqualTo("xzy");
        assertThat(alienOrder(Util.stringArray("wrt", "wrf", "er", "ett", "rftt"))).isEqualTo("wertf");
        assertThat(alienOrder(Util.stringArray("z", "x"))).isEqualTo("zx");
        assertThat(alienOrder(Util.stringArray("z", "x", "z"))).isEqualTo("");
    }
}
