package com.deepak.LFUCacheCSV;


import org.json.JSONObject;

/**
 * @author - deepak-pt3107
 * @createdOn - 03-02-2020
 */
public class Node {
    String key;
    JSONObject value;
    int frequency;
    Node prev;
    Node next;
    public Node(String key,JSONObject value,int frequency){
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}
