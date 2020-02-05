package com.deepak.LFUCache;

/**
 * @author - deepak-pt3107
 * @createdOn - 03-02-2020
 */
public class LFUCacheAlgoTest {
    public static void main(String args[]){
        System.out.println("Going to test the LFU Cache Implementation");

        LFUCache cache = new LFUCache(25000);
        for(long i = 1;i <= 25000 ; i++){
            cache.put(i,i+1);
        }
        cache.LFUCacheAllData();
        while(true){

        }
        /*//Storing first value 10 with key (1) in the cache with default frequency.
        cache.put(1l, 10);

        //Storing second value 20 with key (2) in the cache with default frequency.
        cache.put(2l, 20);

        //Storing third value 30 with key (3) in the cache with default frequency.
        cache.put(3l, 30);

        //Storing fourth value 40 with key (4) in the cache with default frequency.
        cache.put(4l, 40);

        //Storing fifth value 50 with key (5) in the cache with default frequency.
        cache.put(5l, 50);


        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns 10 and increased frequency

        // evicts key 2 and store a key (6) with value 60 in the cache  with default frequency.
        cache.put(6l, 60);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)

        //evicts key 3 and store a key (7) with value 70 in the cache with default frequency.
        cache.put(7l, 70);

        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns -1 (not found)

        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // returns 40

        System.out.println("Value for the key: 5 is " +
                cache.get(5)); // return 50

        for (long i = 1;i <= 10 ; i++){
            System.out.println(cache.get(i));
        }*/
    }

}

