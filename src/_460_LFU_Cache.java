import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LFUCache cache = new LFUCache( 2  // capacity );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * @author shengyizhang
 *
 */
 
public class _460_LFU_Cache {

	HashMap<Integer, Integer> keyValue;//store key value paire
    HashMap<Integer, Integer> keyFreq; // store key and its frequency
    HashMap<Integer, LinkedHashSet<Integer>> freqKeys;//store frequency and associated keys
    int capacity;
    int min; 
    public _460_LFU_Cache(int capacity) {
        this.keyValue = new HashMap<Integer, Integer>();
        this.keyFreq = new HashMap<Integer, Integer>();
        this.freqKeys = new HashMap<Integer, LinkedHashSet<Integer>>();
        this.capacity = capacity;
        this.min = 0;
    }
    
    public int get(int key) {
        if (!keyValue.containsKey(key)) {
            return -1;
        }
        
        int count = keyFreq.get(key);
        keyFreq.put(key, count + 1);
        freqKeys.get(count).remove(key);
        if (min == count && freqKeys.get(count).size() == 0) {
            min++;
        }
        
        if (!freqKeys.containsKey(count + 1)) {
            freqKeys.put(count + 1, new LinkedHashSet<Integer>());
        }
        // if (freqKeys.get(count) == null) {
        //     freqKeys.get(count) = new LinkedHashSet<Integer>();
        // }
        freqKeys.get(count + 1).add(key);
        return keyValue.get(key);
        
    }
    
    public void put(int key, int value) {
    	if (capacity <= 0) {
    		return;
    	}
    	
        if (keyValue.containsKey(key)) {
            keyValue.put(key, value);
            get(key);//trick: do not need to rewrite the update, just call get function
            return;
        } else {
            if (keyValue.size() >= capacity) {
                int evit = freqKeys.get(min).iterator().next();//question:当fre相同时 如何删除最不常用的？？？
                freqKeys.get(min).remove(evit);
                keyValue.remove(evit);
                keyFreq.remove(evit);
            }      
//remove least freq first and then insert
//need to find the min freq to remove, since maybe the table do not even have a freq of 1   
            if (!freqKeys.containsKey(1)) {
            	freqKeys.put(1, new LinkedHashSet<Integer>());
            }
            freqKeys.get(1).add(key);
            keyValue.put(key, value);
            keyFreq.put(key, 1);
            min = 1; 
        } 
        
    }
    
    public static void main(String[] args) {
    	_460_LFU_Cache test = new _460_LFU_Cache(2);
    	test.put(1, 1);
    	test.put(2, 2);
    	test.get(1);
    }
}
