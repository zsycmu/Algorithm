import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * @author Shengyi
 *
 */
//Note: http://blog.csdn.net/awawfwfw/article/details/53081423
//Pass if time is tight
public class _447_Number_of_Boomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int result = 0;
		
		for (int i = 0; i < points.length; i++) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = 0; j < points.length; j++) {
				int a = points[i][0] - points[j][0];
				int b = points[i][1] - points[j][1];
				int distance = (a * a) + (b * b);
				if (map.containsKey(distance)) {
					map.put(distance, map.get(distance) + 1);
				} else {
					map.put(distance, 1);
				}
			}
			
			for (int key : map.keySet()) {
				int value = map.get(key);
				result += value * (value - 1);
			}
		}
		
		return result;
    }
}
