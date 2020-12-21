package com.leetcode;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode save = head;
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        head = save;
        while(head != null && head.val == stack.pop().val){
            head = head.next;
        }
        return stack.isEmpty();
    }
}
