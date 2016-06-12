class BubbleSort {
	public static void bubbleSort(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j+1);
				}
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
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
        bubbleSort(nums);
        System.out.print("After sorting: ");
        printArray(nums);
    }
}