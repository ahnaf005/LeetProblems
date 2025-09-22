package com.company.linkedlist;

public class removeDuplicatesSorted {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int dupCount= 0;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val) {
                dupCount++;
            } else{
                if(dupCount == 0) {
                    prev = cur;
                } else{
                    prev.next = cur.next;
                }
                dupCount = 0;
            }
            cur = cur.next;
        }
        if(dupCount != 0 ){
            prev.next = null;
        }
        return dummy.next;
    }
}
