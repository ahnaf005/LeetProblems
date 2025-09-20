package com.company.linkedlist;

public class reverseList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i=1;i<left;i++){
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode next = start.next;

        for(int i=left+1;i<right;i++){
            start.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = start.next;
        }
        return dummy.next;
    }
}
