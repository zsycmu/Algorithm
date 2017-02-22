/**
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * 
 * Hint:
 * 
 * Expected runtime complexity is in O(log n) and the input is sorted.
 * @author Shengyi
 *
 */
// Note:找到符合条件的边界，然后做判断

public class _275_H_Index_II {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
        	return 0;
        }
        
        int start = 0;
        int end = citations.length - 1;
        
        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	int h = citations.length - mid;
        	if (citations[mid] >= h) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        
        if (citations[start] >= citations.length - start) {
        	return citations.length - start;
        } else if (citations[end] >= citations.length - end) {
        	return citations.length - end;
        } else {
            return 0;
        }
    }
}
