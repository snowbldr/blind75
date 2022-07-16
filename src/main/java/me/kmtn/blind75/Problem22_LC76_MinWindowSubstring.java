package me.kmtn.blind75;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/minimum-window-substring/
public class Problem22_LC76_MinWindowSubstring {

    static String minWindow(String s, String t) {
        Map<Character, Integer> toFindCounts = new HashMap<>(t.length());
        for (Character c : t.toCharArray()) {
            toFindCounts.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        Map<Character, Integer> currentCounts = new HashMap<>();
        for (Character c : t.toCharArray()) {
            currentCounts.put(c, 0);
        }
        int need = toFindCounts.values().stream().mapToInt(i -> i).sum();
        int have = 0;
        int l = 0, r = 0;
        int minL = -1, minR = s.length() + 1;
        while (l < s.length() && r < s.length()) {
            char c = s.charAt(r);
            //Current character is a character we're looking for
            if (toFindCounts.containsKey(c)) {
                //add one to the counts
                currentCounts.compute(c, (k, v) -> v + 1);
                //if we now have exactly as many as we need, add it to the have count to track whether the string is an answer
                if (currentCounts.get(c).equals(toFindCounts.get(c))) {
                    have += toFindCounts.get(c);
                }
            }
            //while the string is a valid answer
            //advance the left pointer until the string is invalid
            while (have == need && l < s.length()) {
                //we found a shorter substring
                if (r - l < minR - minL) {
                    minL = l;
                    minR = r;
                }
                char lc = s.charAt(l);
                if (toFindCounts.containsKey(lc)) {
                    currentCounts.compute(lc, (k, v) -> v - 1);
                    if (currentCounts.get(lc) < toFindCounts.get(lc)) {
                        have -= toFindCounts.get(lc);
                    }
                }
                l++;
            }
            r++;
        }
        return minL > -1 ? s.substring(minL, minR + 1) : "";
    }

    public static void main(String[] args) {
        assertThat(minWindow("a", "aa")).isEqualTo("");
        assertThat(minWindow("a", "a")).isEqualTo("a");
        assertThat(minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
        assertThat(minWindow("foobarArrrrarzzAbbbaz", "aA")).isEqualTo("arA");
        assertThat(minWindow("wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon",
                "ozgzyywxvtublcl")).isEqualTo("tcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanl");
    }
}
