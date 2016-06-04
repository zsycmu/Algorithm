import java.util.HashMap;
import java.util.Map;

public class _01_Two_Sum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = {0, 0};

		if (nums == null || nums.length == 0) {
			return result;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int find = target - nums[i];
			if (map.containsKey(find)) {
				result[0] = map.get(find);
				result[1] = i;
				return result;
			}
			map.put(nums[i], i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] input = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(input, target);
		
		for (int i : result) {
			System.out.println(i + " ");
		}
	}
}
