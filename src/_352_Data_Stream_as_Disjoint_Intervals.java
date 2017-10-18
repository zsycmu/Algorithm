import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * 
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 * @author Shengyi
 *
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class _352_Data_Stream_as_Disjoint_Intervals {
	List<Interval> list;
    
    /** Initialize your data structure here. */
    public _352_Data_Stream_as_Disjoint_Intervals() {
        list = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        Collections.sort(list, new Comparator<Interval>() {
           public int compare(Interval i, Interval j) {
               if (i.start < j.start) {
                   return -1;
               } else if (i.start > j.start) {
                   return 1;
               } else {
                   return 0;
               }
           } 
        });
        
        Interval newInterval = new Interval(val, val);
        List<Interval> newIntervals = new ArrayList<Interval>();
        
        for (int i = 0; i < list.size(); i++) {
            Interval temp = list.get(i);
            if (newInterval.end < temp.start - 1) {
                newIntervals.add(newInterval);
                newInterval = temp;
            } else if (newInterval.start > temp.end + 1) {
                newIntervals.add(temp);
            } else {
                newInterval = new Interval(Math.min(newInterval.start, temp.start), Math.max(newInterval.end, temp.end));
            }
        }
        
        newIntervals.add(newInterval);
        
        list = newIntervals;
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */