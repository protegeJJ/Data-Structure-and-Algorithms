/* Count sort
 * @author JJ
 * @date 06/12/2016
 */

public class CountSort {
	public static int findMax(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		return max;
	}

	public static int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		return min;
	}

	public static void countSort(int[] nums, int min, int max) {
		int[] count = new int[max - min + 1];
		for (int num : nums) {
			++count[num - min];
		}

		int index = 0;
		for (int i = min; i <= max; i++) {
			while (count[i - min] > 0) {
				nums[index] = i;
				++index;
				--count[i - min];
			}
		}
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
        int min = findMin(nums);
        int max = findMax(nums);
        countSort(nums, min, max);
        System.out.print("After sorting: ");
        printArray(nums);
    }
}