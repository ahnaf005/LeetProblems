package com.company.linkedlist;

import java.util.HashMap;

public class randomCopy {
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) {
            return map.get(head);
        }
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);
        return newHead;
    }
}
