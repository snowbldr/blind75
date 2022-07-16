package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static int[] intArray(int... vals) {
        return vals;
    }
    public static String[] stringArray(String... vals) {
        return vals;
    }

    public static int[] intArrayFromString(String arr) {
        return Arrays.stream(arr.trim().substring(1, arr.length() - 1).split(",")).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
    }

    public static List<String> stringListFromString(String arr) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inString = false;
        for (char c : arr.trim().substring(1, arr.length() - 1).toCharArray()) {
            if (c == '"') {
                if (inString) {
                    result.add(sb.toString());
                    sb = new StringBuilder();
                    inString = false;
                } else {
                    inString = true;
                }
            } else {
                if (inString) {
                    sb.append(c);
                }
            }
        }
        return result;
    }

    public static String[][] twoDStringArrayFromString(String arr) {
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inArray = false;
        //skip the first and last character because they're just starting the outer array
        for (char c : arr.trim().substring(1, arr.length() - 1).toCharArray()) {

            switch (c) {
                case '[':
                    inArray = true;
                    sb.append(c);
                    break;
                case ']':
                    inArray = false;
                    sb.append(c);
                    result.add(stringListFromString(sb.toString()));
                    sb = new StringBuilder();
                    break;
                default:
                    if (inArray) sb.append(c);
            }
        }
        return result.stream().map(v -> v.toArray(String[]::new)).toArray(String[][]::new);
    }

    public static char[][] twoDCharArrayFromString(String arr) {
        String[][] strings = twoDStringArrayFromString(arr);
        char[][] res = new char[strings.length][];
        for(int i=0; i<strings.length; i++){
            res[i] = new char[strings[i].length];
            for(int j=0; j<strings.length; j++){
                res[i][j] = strings[i][j].charAt(0);
            }
        }
        return res;
    }

    public static int[][] twoDIntArrayFromString(String arr) {
        return Arrays.stream(twoDStringArrayFromString(arr.replaceAll("([0-9]+)", "\"$1\""))).map(v->Arrays.stream(v).mapToInt(Integer::valueOf).toArray()).toArray(int[][]::new);
    }
}
