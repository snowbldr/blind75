package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/encode-and-decode-strings/
public class Problem62_LC271_EncodeDecodeStrings {
    public static class Codec {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            return String.join("\u0000", strs);
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '/') {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }
            res.add(sb.toString());
            return res;
        }
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        List<String> s = List.of("", "foo", "", "", "bar", "baz");
        assertThat(c.decode(c.encode(s))).isEqualTo(s);
        assertThat(c.decode(c.encode(List.of("")))).isEqualTo(List.of(""));
    }
}
