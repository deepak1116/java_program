package com.deepak.LRUCache;

/**
 * @author - deepak-pt3107
 * @createdOn - 04-02-2020
 */
public class Node {
    long key;
    long value;
    Node prev;
    Node next;

    public Node(Node prev,Node next,long key,long value){
        this.prev = prev;
        this.next = next;
        this.key = key;
        this.value = value;
    }
}
