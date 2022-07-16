package me.kmtn.blind75;

import java.util.List;

import static java.util.Arrays.asList;
import static me.kmtn.blind75.ListNode.linkedList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class Problem8_LC21_MergeTwoLists {
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        ListNode cur1 = list1, cur2 = list2;
        while(cur1 != null || cur2 != null) {
            if(cur1 != null && (cur2 == null || cur1.val < cur2.val)) {
                head.next = cur1;
                head = cur1;
                cur1 = cur1.next;
            } else {
                head.next = cur2;
                head = cur2;
                cur2 = cur2.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        assertThat(mergeTwoLists(linkedList(1,2,4), linkedList(1,3,4)).toList()).isEqualTo(asList(1,1,2,3,4,4));
        assertThat(mergeTwoLists(null, null)).isNull();
        assertThat(mergeTwoLists(null, linkedList(0)).toList()).isEqualTo(List.of(0));
        assertThat(mergeTwoLists(linkedList(0), null).toList()).isEqualTo(List.of(0));
    }
}
