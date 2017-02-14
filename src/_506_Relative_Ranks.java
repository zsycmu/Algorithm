import java.util.Arrays;

/**
 * 
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 * @author Shengyi
 *
 */
// Note: Sore bigger rank is higher.
public class _506_Relative_Ranks {
	public static String[] findRelativeRanks(int[] nums) {
		int[] arrayCopy = new int[nums.length];
		
		for (int i = 0; i < arrayCopy.length; i++) {
			arrayCopy[i] = nums[i];
		}
		
		Arrays.sort(arrayCopy);
		
        String[] result = new String[nums.length];
        
        for (int i = 0; i < result.length; i++) {
        	int rank = -1;
            for (int j = 0; j < nums.length; j++) {
            	if (arrayCopy[j] == nums[i]) {
            		rank = nums.length - 1 - j;
            	}
            }
            
            if (rank == 0) {
            	result[i] = "Gold Medal";
            } else if (rank == 1) {
            	result[i] = "Silver Medal";
            } else if (rank == 2) {
            	result[i] = "Bronze Medal";
            } else {
            	result[i] = String.valueOf(rank + 1);
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input = {5,4,3,2,1};
		
		String[] result = findRelativeRanks(input);
		
		for (String i : result) {
			System.out.println(i);
		}
	}
}
