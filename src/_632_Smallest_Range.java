import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
 * 
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * 
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation: 
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Note:
 * The given list may contain duplicates, so ascending order means >= here.
 * 1 <= k <= 3500
 * -105 <= value of elements <= 105.
 * For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.
 * @author shengyizhang
 *
 */

class Point {
	int listIndex;
	int value;
	
	public Point(int listIndex, int value) {
		this.listIndex = listIndex;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "(" + listIndex + " " + value + ")";
	}
}

public class _632_Smallest_Range {
	public static int[] smallestRange(List<List<Integer>> nums) {
		if (nums == null || nums.size() == 0) {
            return new int[0];
        }
        
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
        	public int compare(Point p1, Point p2) {
        		return p1.value - p2.value;
        	}
        });
        
        for (int i = 0; i < nums.size(); i++) {
        	List<Integer> list = nums.get(i);
        	for (int j = 0; j < list.size(); j++) {
        		queue.offer(new Point(i, list.get(j)));
        	}
        }
        
        List<Point> sortedList = new ArrayList<Point>();
        
        while (!queue.isEmpty()) {
        	sortedList.add(queue.poll());
        }

        System.out.println(sortedList);
        
        int start = 0;
        int end = 0;
        int head = 0;
        int tail = sortedList.size() - 1;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        
        for (; end < sortedList.size(); end++) {
        	Point endPoint = sortedList.get(end);
        	if (map.containsKey(endPoint.listIndex)) {
        		int count = map.get(endPoint.listIndex);
        		map.put(endPoint.listIndex, count + 1);
        	} else {
        		map.put(endPoint.listIndex, 1);
        	}
        	
        	if (map.size() == nums.size()) {
        		Point startPoint = sortedList.get(start);
        		while (start < end && (map.containsKey(startPoint.listIndex) && map.get(startPoint.listIndex) > 1)) {
    				int count = map.get(startPoint.listIndex);
					map.put(startPoint.listIndex, count - 1);
        			start++;
        			startPoint = sortedList.get(start);
        		}
        		
        		if (sortedList.get(tail).value - sortedList.get(head).value > sortedList.get(end).value - sortedList.get(start).value) {
        			head = start;
        			tail = end;
        		}
        	}
        }
        
        return new int[]{sortedList.get(head).value, sortedList.get(tail).value};
    }
	
	public static void main(String[] args) {
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		List<Integer> l = Arrays.asList(4,10,15,24,26);
		nums.add(l);
		List<Integer> m = Arrays.asList(0,9,12,20);
		nums.add(m);
		List<Integer> n = Arrays.asList(5,18,22,30);
		nums.add(n);
		
		System.out.println(smallestRange(nums)[0] + " " + smallestRange(nums)[1]);
	}
}
