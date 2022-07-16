package me.kmtn.blind75;

import java.util.List;

import static java.util.Arrays.asList;
import static me.kmtn.blind75.ListNode.linkedList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class Problem6_LC19_RemoveNthNode {
    static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head),
                 left = dummy,
                 right = head;
        while(n>0 && right != null){
            right = right.next;
            n--;
        }

        while(right != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;

    }

    public static void main(String[] args) {
        assertThat(removeNthFromEnd(linkedList(1,2,3,4,5), 2).toList()).isEqualTo(asList(1,2,3,5));
        assertThat(removeNthFromEnd(linkedList(1), 1).toList()).isEqualTo(List.of());
        assertThat(removeNthFromEnd(linkedList(1,2), 1).toList()).isEqualTo(List.of(1));
    }
}
