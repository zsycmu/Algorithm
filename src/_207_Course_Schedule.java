import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * click to show more hints.
 * 
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 * @author Shengyi
 *
 */

//Notice: Do it again, it will be good to see again.
public class _207_Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
        	return true;
        }
        
        int[] pCount = new int[numCourses]; //The length of prerequisites is not the number of the course
        
        for (int i = 0; i < prerequisites.length; i++) {
        	int currentDep = prerequisites[i][0];
        	pCount[currentDep]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < pCount.length; i++) {
        	if (pCount[i] == 0) {
        		queue.offer(i);
        	}
        }
        
        int courseCount = queue.size(); //This is another key.
        
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		int currentCourse = queue.poll();
        		for (int j = 0; j < prerequisites.length; j++) {
        			if (prerequisites[j][1] == currentCourse) {
        				pCount[prerequisites[j][0]]--;
        				if (pCount[prerequisites[j][0]] == 0) {
        					queue.offer(prerequisites[j][0]);
        					courseCount++;
        				}
        			}
        		}
        	}
        }
        
        return courseCount == numCourses;
    }
}
