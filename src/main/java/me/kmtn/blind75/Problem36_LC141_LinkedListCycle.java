package me.kmtn.blind75;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/linked-list-cycle/
public class Problem36_LC141_LinkedListCycle {

    static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    static boolean detectCycle(ListNode head, Set<ListNode> visited){
        if(head == null){
            return false;
        }
        if(visited.contains(head)){
            return true;
        }
        visited.add(head);
        return detectCycle(head.next, visited);
    }

    public static void main(String[] args) {
        ListNode list = ListNode.linkedList(3, 2, 0, -4);
        assertThat(hasCycle(list)).isFalse();
        list.next.next.next.next = list.next.next;
        assertThat(hasCycle(list)).isTrue();
    }
}
