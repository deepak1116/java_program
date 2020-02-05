package com.deepak.LRUCache;

/**
 * @author - deepak-pt3107
 * @createdOn - 04-02-2020
 */
public class LRUCacheTest {

    public static void main(String args[]){
        LRUCache lrutest = new LRUCache(5);
        lrutest.put(1l,10l);
        lrutest.put(2l,20l);
        lrutest.put(3l,30l);
        lrutest.put(4l,40l);
        lrutest.put(5l,50l);
        lrutest.get(1l);
        lrutest.get(2l);
        lrutest.get(5l);
        lrutest.put(6l,60l);
        lrutest.put(7l,70l);
        lrutest.put(8l,80l);
        lrutest.get(7l);
        lrutest.put(10l,100l);
        lrutest.get(5l);
        lrutest.get(5l);
        lrutest.listKeyValue();
    }
}
