package com.company.linkedlist;

public class removeNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int count = 0;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        while (cur != null) {
            if (count == (len - n)) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
            count++;
        }
        return dummy.next;
    }
}
