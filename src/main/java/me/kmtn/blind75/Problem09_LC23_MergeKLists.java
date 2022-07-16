package me.kmtn.blind75;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Arrays.asList;
import static me.kmtn.blind75.ListNode.linkedList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class Problem09_LC23_MergeKLists {
    static ListNode mergeKListsPQ(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparing((ln) -> ln.val));
        for (ListNode ln : lists) {
            if (ln != null) q.add(ln);
        }
        while (!q.isEmpty()) {
            head.next = q.poll();
            head = head.next;
            if (head.next != null) {
                q.add(head.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        assertThat(mergeKListsPQ(new ListNode[]{linkedList(1, 4, 5), linkedList(1, 3, 4), linkedList(2, 6)}).toList()).isEqualTo(asList(1, 1, 2, 3, 4, 4, 5, 6));
        assertThat(mergeKListsPQ(new ListNode[]{null, null})).isNull();
        assertThat(mergeKListsPQ(new ListNode[]{null, linkedList(0)}).toList()).isEqualTo(List.of(0));
        assertThat(mergeKListsPQ(new ListNode[]{linkedList(0), null}).toList()).isEqualTo(List.of(0));
    }
}
