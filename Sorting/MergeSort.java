/* 
 * Merge Sort
 * @author JJ
 * @date 06/12/2016 
 */

class MergeSort {
	public static void mergeSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		mergeSort_topDown(nums, 0, nums.length - 1);
	}

	public static void mergeSort_topDown(int[] nums, int start, int end) {
		if (nums == null || start >= end) {
			return;
		}

		int mid = (start + end) >> 1;
		mergeSort_topDown(nums, start, mid);
		mergeSort_topDown(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}

	public static void merge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;                          // index for temp array
		while (i <= mid && j <= end) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			}
			else {
				temp[k++] = nums[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		while (j <= end) {
			temp[k++] = nums[j++];
		}

		for (i = 0; i < k; i++) {
			nums[start + i] = temp[i];
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
        mergeSort(nums);
        System.out.print("After sorting: ");
        printArray(nums);
    }
}