package me.kmtn.blind75;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/reverse-linked-list/
public class Problem44_LC206_ReverseLinkedList {

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        assertThat(reverseList(ListNode.linkedList(1,2,3,4,5)).toList()).isEqualTo(List.of(5,4,3,2,1));
    }
}
