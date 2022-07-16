package me.kmtn.blind75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/reorder-list/
public class Problem37_LC143_ReorderList {

    static void reorderList(ListNode head) {
        if(head == null) return;
        ListNode ms = head, mf = head;
        while(mf != null && mf.next != null){
            ms = ms.next;
            mf = mf.next.next;
        }
        ListNode mid = ms;
        ListNode reverseHead = null;
        ListNode curr = mid;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = reverseHead;
            reverseHead = curr;
            curr = next;
        }

        ListNode a = head;
        ListNode b = reverseHead;
        while(b.next != null){
            ListNode temp1 = a.next;
            a.next = b;
            a = temp1;

            ListNode temp2 = b.next;
            b.next = a;
            b = temp2;
        }
    }

    static void reorderListDeque(ListNode head) {
        if(head != null){
            Deque<ListNode> nodes = new ArrayDeque<>();
            ListNode curr = head;
            while(curr != null){
                nodes.add(curr);
                curr = curr.next;
            }
            curr = nodes.pollFirst();
            while(!nodes.isEmpty()){
                curr.next = nodes.pollLast();
                if(curr.next != null) {
                    curr.next.next = nodes.pollFirst();
                    if(curr.next.next !=null){
                        curr = curr.next.next;
                        curr.next = null;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.linkedList(1,2,3,4,5,6,7,8);
        reorderList(list1);
        assertThat(list1.toList()).isEqualTo(List.of(1,8,2,7,3,6,4,5));
        ListNode list = ListNode.linkedList(1,2,3,4,5,6,7,8,9);
        reorderList(list);
        assertThat(list.toList()).isEqualTo(List.of(1,9,2,8,3,7,4,6,5));

    }
}
