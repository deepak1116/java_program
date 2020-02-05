package com.deepak.LRUCacheCSVTest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;

/**
 * @author - deepak-pt3107
 * @createdOn - 04-02-2020
 */
public class LRUCache {
    private Node lru;
    private Node mru;
    private HashMap<String,Node> map;
    private int capacity;
    private int currentSize;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.currentSize = 0;
        lru = new Node(null,null,null,null);
        mru = lru;
        map = new HashMap<>();
    }

    public void listKeyValue(){
        Set<String> keys = this.map.keySet();
        for(String key : keys){
            System.out.println(key);
        }
    }
    public JSONObject get(String key){
        Node tempNode = map.get(key);
        if(tempNode == null){
            return new JSONObject();
        }else if(tempNode.key == mru.key){
            return mru.value;
        }

        Node nextNode = tempNode.next;
        Node prevNode = tempNode.prev;

        if(tempNode.key == lru.key){
            nextNode.prev = null;
            lru = nextNode;
        }else if(tempNode.key != mru.key){
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        tempNode.prev = mru;
        mru.next = tempNode;
        mru = tempNode;
        mru.next = null;

        return tempNode.value;
    }

    public void put(String key,JSONObject value){
        if(map.containsKey(key)){
            return;
        }
        Node newNode = new Node(mru,null,key,value);
        mru.next = newNode;
        map.put(key,newNode);
        mru = newNode;

        if(currentSize == capacity){
            map.remove(lru.key);
            lru = lru.next;
            lru.prev = null;
        }else if(currentSize < capacity){
            if(currentSize == 0){
                lru =newNode;
            }
            currentSize++;
        }
    }
}
