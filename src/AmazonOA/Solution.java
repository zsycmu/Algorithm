package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "start: " + start + " " + "end: " + end;
	}
}

public class Solution {
	public List<List<Interval>> groupMeetings(List<Interval> meetings) {
		List<List<Interval>> result = new ArrayList<List<Interval>>();
		
		if (meetings == null || meetings.size() == 0) {
			return result;
		}
		
		// 给输入的meeting排序
		Collections.sort(meetings, new Comparator<Interval>() {
		
			public int compare(Interval i1, Interval i2) {
				if (i1.start < i2.start) {
					return -1;
				} else if (i1.start > i2.start) {
					return 1;
				} else {
					if (i1.end < i2.end) {
						return -1;
					} else if (i1.end > i2.end) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});
		
		// visited来track输入的每一个interval是不是已经安排了
		Set<Interval> visited = new HashSet<Interval>();
		
		// 当interval没有完全被安排的时候进while循环
		while (meetings.size() > visited.size()) {
			// 每一个不overlap得list
			List<Interval> tempList = new ArrayList<Interval>();
			
			// 用来找第一个没有被安排的meeting interval
			int nonScheduledIndex = 0;
			
			
			while (visited.contains(meetings.get(nonScheduledIndex))) {
				nonScheduledIndex++;
			}
			
			// 如果全被安排了就跳出循环
			if (nonScheduledIndex == meetings.size()) {
				break;
			}
			
			// 从这里以后就是找每一个没有被安排的并且不重叠的
			Interval temp = meetings.get(nonScheduledIndex);
			visited.add(temp);
			tempList.add(temp);
			
			for (int i = nonScheduledIndex + 1; i < meetings.size(); i++) {
				Interval currentInterval = meetings.get(i);
				if (!visited.contains(currentInterval) && currentInterval.start > temp.end) {
					visited.add(currentInterval);
					tempList.add(currentInterval);
					temp = currentInterval;
				}
			}
			
			result.add(tempList);
		}
		
		
		return result;
		
	}
		
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(0, 5));
		input.add(new Interval(10, 15));
		input.add(new Interval(20, 25));
		input.add(new Interval(3, 12));
		input.add(new Interval(13, 22));
		input.add(new Interval(11, 16));
		
		Solution test = new Solution();
		List<List<Interval>> result = test.groupMeetings(input);
		System.out.print(result);
	}

}