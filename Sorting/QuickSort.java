/*
 * Quick Sort
 * @author JJ
 * @date 06/12/2016
 */


class QuickSort {
	public static void quickSort(int[] nums) {
		recQuickSort(nums, 0, nums.length - 1);
	}

	public static void recQuickSort(int[] nums, int start, int end) {
		int pivot = partition(nums, start, end);
	    recQuickSort(nums, start, pivot - 1);
	    recQuickSort(nums, pivot + 1, end );
	}

	public static int partition(int[] nums, int start, int end) {
		// Use the middle element as pivot
		int pivot = (start + end) >> 1;
		// Put the pivot to the end
		swap(nums, pivot, end);

		// Put element smaller than the pivot to the first half of array
		for (int i = start; i < end; i++) {
			if (nums[i] > nums[end]) {
				swap(nums, i, start);
				++start;
			}
		}
		// Put the pivot back to position it should be
		swap(nums, start, end);
		return start;


	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String args[]) {
		int[] nums = {2, 5, 3, 100, 2, 3, 8, 3};
        System.out.print("Before sorting: ");
        printArray(nums);
        quickSort(nums);
        System.out.print("After sorting: ");
        printArray(nums);

	}
}