package com.company.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node1 {
    int key, val;
    Node1 next, prev;

    Node1(int k, int v) {
        key = k;
        val = v;
        next = null;
        prev = null;
    }
}
public class LRUCache {

    int cap;
    Map<Integer, Node1> cache;
    Node1 left, right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        left = new Node1(0, 0);
        right = new Node1(0, 0);
        left.next = right;
        right.prev = left;
    }

    private void remove(Node1 node) {
        Node1 prev, next;
        prev = node.prev;
        next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node1 node) {
        Node1 prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        // key doesn't exist now..
        cache.put(key, new Node1(key, value));
        insert(cache.get(key));
        // capacity exceeds!
        if (cache.size() > cap) {
            // remove from linked list and delete the LRU from the cache..
            Node1 lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
