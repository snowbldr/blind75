package me.kmtn.blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class Problem33_LC128_LongestConsecutiveSequence {

    static  int longestConsecutive(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        for(int n:nums){
            uniqueNums.add(n);
        }
        int max = 0;
        for(int n : uniqueNums){
            //start of sequence
            if(!uniqueNums.contains(n-1)){
                int curr = n, currMax = 0;
                while(uniqueNums.contains(curr++)){
                    currMax++;
                }
                max = Math.max(max, currMax);
            }
        }
        return max;
    }

    static int longestConsecutiveMap(int[] nums) {
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        for(int n:nums){
            ListNode node = nodeMap.computeIfAbsent(n, ListNode::new);
            nodeMap.computeIfPresent(n-1, (k, prev) -> {
                node.prev = prev;
                prev.next = node;
                return prev;
            });
            nodeMap.computeIfPresent(n+1, (k, next) -> {
                next.prev = node;
                node.next = next;
                return next;
            });
        }
        int max = 0;
        for(ListNode node : nodeMap.values()){
            //skip roots with a previous, as they are not roots
            if(node.prev == null){
                max = Math.max(max, node.length());
            }
        }
        return max;
    }

    static class ListNode {
        ListNode prev, next;
        int val;
        ListNode(int val){
            this.val = val;
        }

        int length() {
            int i=1;
            ListNode curr = this;
            while(curr.next != null){
                i++;
                curr = curr.next;
            }
            return i;
        }
    }
    public static void main(String[] args) {
        assertThat(longestConsecutive(new int[]{-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7})).isEqualTo(4);
        assertThat(longestConsecutive(new int[]{100,4,200,1,3,2})).isEqualTo(4);
        assertThat(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})).isEqualTo(9);
    }
}
