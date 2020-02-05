package com.deepak.LFUCache;

import java.util.HashMap;
import java.util.Set;

/**
 * @author - deepak-pt3107
 * @createdOn - 03-02-2020
 */
public class LFUCache {
    Node head;
    Node tail;
    HashMap<Long,Node> map = null;
    long capacity = 0;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    public void LFUCacheAllData(){
        Set<Long> keys= this.map.keySet();
        for(long key:keys){
            System.out.println(key);
        }
    }
    public long get(long key){
        if (map.get(key) == null){
            return -1;
        }

        Node item = map.get(key);
        removeNode(item);
        item.frequency = item.frequency + 1;
        addNodeWithUpdatedFrequency(item);
        return item.value;
    }

    public void put(Long key,long value){
        if(map.containsKey(key)){
            Node item = map.get(key);
            item.value = value;
            item.frequency = item.frequency + 1;
            removeNode(item);
            addNodeWithUpdatedFrequency(item);
        }else{
            if((long)map.size() >= capacity){
                map.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value,1);
            addNodeWithUpdatedFrequency(node);
            map.put(key,node);
        }
    }

    public void removeNode(Node node){
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
    }

    private void addNodeWithUpdatedFrequency(Node node){
        if(tail != null && head != null){
            Node temp = head;
            while(temp != null){
                if(temp.frequency > node.frequency){
                    if(temp == head){
                        node.next = temp;
                        temp.prev = node;
                        head = node;
                        break;
                    }else{
                        node.next = temp;
                        node.prev = temp.prev;
                        head = node;
                        break;
                    }
                }else{
                    temp = temp.next;
                    if(temp == null){
                        tail.next = node;
                        node.prev = tail;
                        node.next = null;
                        tail = node;
                        break;
                    }

                }
            }
        }else{
            tail = node;
            head = tail;
        }
    }
}
