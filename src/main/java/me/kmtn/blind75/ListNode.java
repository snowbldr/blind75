package me.kmtn.blind75;


import java.util.ArrayList;
import java.util.List;

import static me.kmtn.blind75.Util.intArrayFromString;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode linkedList(String list){
        return linkedList(intArrayFromString(list));
    }

    static ListNode linkedList(int ...ints) {
        ListNode head = new ListNode();
        ListNode current = head;
        for(int i =0; i< ints.length; i++){
            current.val = ints[i];
            if(i < ints.length - 1) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return head;
    }

    List<Integer> toList() {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = this;
        list.add(head.val);
        while(head.next != null){
            head = head.next;
            list.add(head.val);
        }
        return list;
    }

}

