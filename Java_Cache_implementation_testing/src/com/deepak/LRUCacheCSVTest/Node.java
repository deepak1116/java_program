package com.deepak.LRUCacheCSVTest;

import org.json.JSONObject;

/**
 * @author - deepak-pt3107
 * @createdOn - 04-02-2020
 */
public class Node {
    String key;
    JSONObject value;
    Node prev;
    Node next;

    public Node(Node prev,Node next,String key,JSONObject value){
        this.prev = prev;
        this.next = next;
        this.key = key;
        this.value = value;
    }
}
