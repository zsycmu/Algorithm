package AmazonOA;

import java.util.LinkedList;
import java.util.Queue;

//Find the min steps of maze
//意思是说有一个M*N的maze，0代表可以通过，1代表不可以通过，然后给你一个出口（x,y），找从（0,0）到出口的最少steps，如果找不到path就返回-1.
//Leetcode原题 Unique Path II
public class Maze {
	public int findMinStep(int[][] maze, int[] target) {
		if (maze == null || maze.length == 0) {
			return 0;
		}
		int[] x = new int[] {-1, 0, 1, 0};
		int[] y = new int[] {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{0,0});
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		int step = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] temp = q.poll();
				
				if (temp[0] == target[0] && temp[1] == target[1]) {
					return step;
				}
				
				for (int k = 0; i < 4; k++) {
					int row = temp[0] + x[k];
					int col = temp[1] + y[k];
					
					if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col]){
						continue;
					}
					q.offer(new int[] {row, col});
					visited[row][col] = true;
				}
			}
			
			step++;
		}
		
		return -1; 
	}
}
