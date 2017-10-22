package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Warehouse {
	public static List<List<Integer>> closestPoint(List<List<Integer>> location, int N,  int M) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		if (location == null || N == 0) {
			return result;
		}

		PriorityQueue<List<Integer>> q = new PriorityQueue<List<Integer>>(N, new Comparator<List<Integer>>() {
			public int compare(List<Integer> a, List<Integer> b){
				return findDistance(a) - findDistance(b);
			}
		});
		
		for (List<Integer> a : location) {
			q.offer(a);
		}
		
		for (int i = 0; i < M; i++) {
			if (!q.isEmpty()) {
				result.add(q.poll());
			}
		}
		
		return result;
	}
	
	private static int findDistance(List<Integer> a) {
		return a.get(0) * a.get(0) + a.get(1) * a.get(1);
	}
	
	public static void main(String[] args) {

		List<List<Integer>> input = new ArrayList<List<Integer>>();


		input.add(Arrays.asList(1,1));

		input.add(Arrays.asList(1,2));

		input.add(Arrays.asList(1,3));

		input.add(Arrays.asList(1,4));

		input.add(Arrays.asList(1,1));

		input.add(Arrays.asList(1,1));

		input.add(Arrays.asList(1,1));


		System.out.println(closestPoint(input, input.size(), 5));


		}
}
