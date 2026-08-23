package com.company.amazon;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev= new ListNode(0);
        prev.next = head;
        ListNode tmp = head;
        int k=0;
        while(tmp!=null){
            tmp=tmp.next;
            k++;
        }
        ListNode start = prev.next;
        ListNode next = start.next;
        while(k>1){
            start.next = next.next;
            next.next=prev.next;
            prev.next=next;
            next = start.next;
            k--;
        }
        return prev.next;
    }
}
