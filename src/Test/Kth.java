package Test;

public class Kth {
	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        k = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            index = partition(nums, start, end);
            if (index < k) {
                start = index + 1;
            } else if (index > k) {
                end = index - 1;
            } else {
                break;
            }
        }
        
        return nums[index];
    }

    public int partition(int[] nums, int i, int j) {
        int pivotIndex = i;
        int pivot = nums[pivotIndex];
        int start = i + 1;
        int end = j;//???

        while (start <= end) {
            if (nums[start] > pivot && nums[end] < pivot) {
                swap(nums, start, end);
                start++;
                end--;
            }

            if (nums[start] <= pivot) {
                start++;
            }

            if (nums[end] >= pivot) {
                end--;
            }
        }
        
        if (i < end) {
            swap(nums, pivotIndex, end);
        }

    ///?????
        return start;
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    public static void main(String[] args) {
    	int[] input = {1};
    	Kth test = new Kth();
    	System.out.println(test.findKthLargest(input, 1));
    }
}
