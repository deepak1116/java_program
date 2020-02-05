package com.deepak.LFUCache;

/**
 * @author - deepak-pt3107
 * @createdOn - 03-02-2020
 */
public class Node {
    long key;
    long value;
    int frequency;
    Node prev;
    Node next;
    public Node(long key,long value,int frequency){
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }

}
