package com.leetcode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        while(first != null) {
            while (second != null && first.val == second.val) {
                second = second.next;
            }
            first.next = second;
            first = second;
            if(second != null) second = second.next;
        }
        return head;
    }
}
