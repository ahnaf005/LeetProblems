package com.company.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        PriorityQueue<ListNode>queue = new PriorityQueue<>
                (Comparator.comparingInt(o -> o.val));
        for(ListNode node: lists){
            queue.add(node);
        }
        while(!queue.isEmpty()){
            ptr.next = queue.poll();
            ptr=ptr.next;
            if(ptr.next!=null){
                queue.add(ptr.next);
            }
        }
        return head.next;
    }
}
