import java.util.Random;

class QuickSelect {
	public static int quickSelect(int[] nums, int k) {
		return recQuickSelect(nums, k - 1, 0, nums.length - 1);
	}    

    // Divide
	public static int recQuickSelect(int[] nums, int k, int start, int end) {
		int pivot = randomizedPartition(nums, start, end);

		if (pivot > k) {
			return recQuickSelect(nums, k, start, pivot - 1);
		}
		else if (pivot < k) {
			return recQuickSelect(nums, k, pivot + 1, end);
		}
		else {
			return nums[pivot];
		}
	}
    
    // Conquer
	public static int randomizedPartition(int[] nums, int start, int end) {
		int pivot = new Random().nextInt(end - start + 1) + start;
		for (int i = start; i < end; i++) {
			if (nums[i] < nums[end]) { // if looking for kth largest element, this line will be nums[i] > nums[end]
				swap(nums, i, start);
				++start;
			}
		}
		swap(nums, start, end);
		return start;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public static void main(String[] args) {
		int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
		int kth = 3;
		int res = quickSelect(nums, kth);
		System.out.println("Find the " + kth + " smallest is " + res);

	}
}