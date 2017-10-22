package OA;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.LinkedList;

public class Golf {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return 0;
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        
        int row = forest.size();
        int col = forest.get(0).size();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) {// only insert trees into the q, not 0 and not 1
                    int[] point = new int[] {i, j, forest.get(i).get(j)};
                    q.offer(point);
                }   
            }
        }
        
        int[] start = new int[] {0,0,forest.get(0).get(0)};
        int result = 0;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int dist = findDist(start, temp, forest);// decide whether is 0
            if (dist == -1) {
                return -1;
            }
            start[0] = temp[0];
            start[1] = temp[1];
            start[2] = temp[2];
            result += dist;
        }
        return result;
    }
    
    
    private int findDist(int[] start, int[] end, List<List<Integer>> forest) {
        Queue<int[]> q = new LinkedList<int[]>();
        int dist = 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[start[0]][start[1]] = true;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        q.offer(start);
        
        while (!q.isEmpty()) {
            int size  = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                if (temp[2] == end[2]) {
                    return dist;
                }
                
                for (int k = 0; k < 4; k++) {
                    int row = temp[0] + dx[k];
                    int col = temp[1] + dy[k];
                    if (row < 0 || row >= forest.size() || col < 0 || col >= forest.get(0).size() || visited[row][col] || forest.get(row).get(col) == 0) {
                        continue;
                    }
                    
                    q.offer(new int[] {row, col, forest.get(row).get(col)});
                    visited[row][col] = true;
                }
            }
            
            dist++;
        }
        
        return -1;
    }
}
