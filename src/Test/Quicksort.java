package Test;
public class Quicksort  {
    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        quicksort(values, 0, values.length - 1);
    }

    private void quicksort(int[] nums, int start, int end) {
        int i = start, j = end;
        // Get the pivot element from the middle of the list

		int pivot = nums[start + (end - start) / 2];
    	System.out.println("test0" + pivot);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (nums[i] < nums[start + (end - start) / 2]) {
            	System.out.println("test1" + nums[start + (end - start) / 2]);
            	System.out.println("test1" + pivot);
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (nums[j] > nums[start + (end - start) / 2]) {
            	System.out.println("test2" + nums[start + (end - start) / 2]);
            	System.out.println("test2" + pivot);
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(nums, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (start < j)
            quicksort(nums, start, j);
        if (i < end)
            quicksort(nums, i, end);
    }

    private void exchange(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
    
    public static void main(String[] args) {
    	int[] input = {3,2,4,7,1,1,1,1};
    	Quicksort sort = new Quicksort();
    	sort.sort(input);
    	
    	for (int i : input) {
    		System.out.println(i);
    	}
    }
}