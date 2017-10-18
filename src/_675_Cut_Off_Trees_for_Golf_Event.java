import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
 * 
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 * 
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 * 
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 * 
 * Example 1:
 * Input: 
 * [
 *  [1,2,3],
 *  [0,0,4],
 *  [7,6,5]
 * ]
 * Output: 6
 * Example 2:
 * Input: 
 * [
 *  [1,2,3],
 *  [0,0,0],
 *  [7,6,5]
 * ]
 * Output: -1
 * Example 3:
 * Input: 
 * [
 *  [2,3,4],
 *  [0,0,5],
 *  [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 * Hint: size of the given matrix will not exceed 50x50.
 * @author Shengyi
 *
 */

// Notice: 第一個點的值可能是1， 這個時候初始化第一個點的時候的值要初始化成[0,0]的值

public class _675_Cut_Off_Trees_for_Golf_Event {
	class Point {
        int val;
        int x;
        int y;
        
        public Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
    	if (forest == null || forest.size() == 0) {
            return 0;
        }
        
        TreeMap<Integer, Point> map = new TreeMap<Integer, Point>();
        
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> tempList = forest.get(i);
            for (int j = 0; j < tempList.size(); j++) {
                int val = tempList.get(j);
                if (val > 1) {
                    Point p = new Point(val, i, j);
                    map.put(val, p);
                }
            }
        }
        
        Point pre = new Point(forest.get(0).get(0), 0, 0);
        int result = 0;
        
        for (Map.Entry<Integer, Point> entry : map.entrySet()) {
            int distance = GetDistanceBetweenTwoPoint(pre, entry.getValue(), forest, new boolean[forest.size()][forest.get(0).size()]);
            
            if (distance == -1) {
                return -1;
            }
            
            result += distance;
            pre = entry.getValue();
        }
        
        return result;
    }
    
    private int GetDistanceBetweenTwoPoint(Point start, Point end, List<List<Integer>> forest, boolean[][] visited) {
        int count = 0;
        
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Point temp = queue.poll();
                if (temp.val == end.val) {
                    return count;
                }
                
                List<Integer> tempList;
                
                if (temp.x != 0) {
                    tempList = forest.get(temp.x - 1);
                    if (tempList.get(temp.y) != 0 && !visited[temp.x - 1][temp.y]) {
                        queue.offer(new Point(tempList.get(temp.y), temp.x - 1, temp.y));
                        visited[temp.x - 1][temp.y] = true;
                    }
                }
                
                if (temp.y != 0) {
                    tempList = forest.get(temp.x);
                    if (tempList.get(temp.y - 1) != 0 && !visited[temp.x][temp.y - 1]) {
                        queue.offer(new Point(tempList.get(temp.y - 1), temp.x, temp.y - 1));
                        visited[temp.x][temp.y - 1] = true;
                    }
                }
                
                if (temp.x != forest.size() - 1) {
                    tempList = forest.get(temp.x + 1);
                    if (tempList.get(temp.y) != 0 && !visited[temp.x + 1][temp.y]) {
                        queue.offer(new Point(tempList.get(temp.y), temp.x + 1, temp.y));
                        visited[temp.x + 1][temp.y] = true;
                    }
                }
                
                if (temp.y != forest.get(0).size() - 1) {
                    tempList = forest.get(temp.x);
                    if (tempList.get(temp.y + 1) != 0 && !visited[temp.x][temp.y + 1]) {
                        queue.offer(new Point(tempList.get(temp.y + 1), temp.x, temp.y + 1));
                        visited[temp.x][temp.y + 1] = true;
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }
}
