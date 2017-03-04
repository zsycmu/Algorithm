import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @author Shengyi
 *
 */
// Pass
class ArrayComparacter implements Comparator<int[]> {
	public int compare(int[] a, int[] b) {
		if (a[1] > b[1]) {
			return -1;
		} else if (a[1] < b[1]) {
			return 1;
		} else {
			return 0;
		}
	}
}
public class _347_Top_K_Frequent_Elements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	int temp = nums[i];
        	int count = 0;
        	if (map.containsKey(temp)) {
        		count = map.get(temp);
        	}
        	count++;
        	map.put(temp, count);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new ArrayComparacter());
        
        for (int key : map.keySet()) {
        	queue.offer(new int[]{key, map.get(key)});
        }
        
        while (k > 0) {
        	int[] temp = queue.poll();
        	result.add(temp[0]);
        	k--;
        }
        
        return result;
    }
}
