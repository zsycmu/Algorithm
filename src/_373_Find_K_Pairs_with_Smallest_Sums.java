import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
 * @author Shengyi
 *
 */
// Note: 注意input不是null也不是空，并且后面的queue不为空。Do not do it again。

class Pair {
	int[] pair;
	int sum;
	
	public Pair(int[] pair, int sum) {
		this.pair = pair;
		this.sum = sum;
	}
}

class CompairPair implements Comparator<Pair> {
	public int compare(Pair p1, Pair p2) {
		if (p1.sum < p2.sum) {
			return -1;
		} else if (p1.sum > p2.sum) {
			return 1;
		} else {
			return 0;
		}
	}
}

public class _373_Find_K_Pairs_with_Smallest_Sums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        
        for (int i = 0; i < nums1.length; i++) {
        	for (int j = 0; j < nums2.length; j++) {
        		int[] pair = new int[]{nums1[i], nums2[j]};
        		int sum = nums1[i] + nums2[j];
        		
        		Pair p = new Pair(pair, sum);
        		
        		queue.offer(p);
        	}
        }
        
        while (!queue.isEmpty() && k > 0) {
        	result.add(queue.poll().pair);
        	k--;
        }
        
        return result;
    }
}
