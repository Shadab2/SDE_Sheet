package DAY14;

import java.util.*;

public class lru_cache {
    // Approach #1
    // use linkedhashmap to maintain insertion order and then on get operation put
    // the calling element to recenlty used in the map
    class LRUCache {
        private LinkedHashMap<Integer, Integer> lru;
        private int capacity;

        public LRUCache(int capacity) {
            lru = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (lru.containsKey(key)) {
                int ret = lru.get(key);
                lru.remove(key);
                lru.put(key, ret);
                return ret;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (lru.containsKey(key))
                lru.remove(key);
            else if (lru.size() == capacity) {
                // get the first element from the map ie. least recenlty used
                int x = lru.entrySet().iterator().next().getKey();
                lru.remove(x);
            }
            lru.put(key, value);
        }
    }

    // Appraoch #2
    // Extend LinkedHashMap will automatically takes care of put operation but we
    // need to define our own get operation as according to the question we need to
    // return -1 when the key is not found
    class LRUCache1 extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache1(int capacity) {
            // initializing parent class
            // the contstructor second param is load factor and third param defines what
            // should be the order
            // ie. if set to true it will have accessOrder rather than insertion order which
            // means if we call get its order will update not based upon how it got inserted
            // but on how frequently its used
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer val = super.get(key);
            return val == null ? -1 : val;
        }

        // this is protected feild and needs to override in order to facilitate max size
        // = capcity
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }

    // Approach #3
    // this can be easiliy implemented using Doubly-linked-list and map
}
