/**
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * @author shengyizhang
 *
 */

public class _042_Trapping_Rain_Water {
	public static int trap(int[] height) {
        int count = 0;
        
        if (height == null || height.length == 0) {
            return count;
        }
        
        int start = 0;
        int end = height.length - 1;
        
        int startMax = 0;
        int endMax = 0;
        
        while (start <= end) {
            if (startMax < endMax) {
                if (height[start] > startMax) {
                    startMax = height[start];
                } else {
                    count += (startMax - height[start]);
                }
                start++;
            } else {
                if (height[end] > endMax) {
                	endMax = height[end];
                } else {
                    count += (endMax - height[end]);
                }
                end--;
            }
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(input));
	}
}
