/* 
 * Merge Sort
 * @author JJ
 * @date 06/12/2016 
 */

class MergeSort {
	public static int findMax(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		return max;
	}

	public static void mergeSort(int[] nums, int max) {
		
	}

	public static void printArray(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}


	public static void main(String args[]) {
        int[] nums = {2, 5, 3, 100, 2, 3, 8, 3};
        System.out.print("Before sorting: ");
        printArray(nums);
        int max = findMax(nums);
        mergeSort(nums, max);
        System.out.print("After sorting: ");
        printArray(nums);
    }
}