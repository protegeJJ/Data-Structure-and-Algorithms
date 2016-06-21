public class SegmentTree {
	public class SegmentTreeNode {
		int start;
		int end;
		int sum;
		int min;
		int max;
		SegmentTreeNode left;
		SegmentTreeNode right;


		public SegmentTreeNode(int start, int end, int sum, int min, int max) {
			this.start = start;
			this.end = end;
			this.sum = sum;
			this.max = min;
			this.min = max;
		}
	}

	public SegmentTreeNode build(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		if (start == end) {
			SegmentTreeNode leaf = new SegmentTreeNode(start, end, nums[start], nums[start], nums[start]);
			return leaf;
		}
         
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0, 0, 0);
		int mid = (start + end) >> 1;
		root.left = build(nums, start, mid);
		root.right = build(nums, mid + 1, end);
		root.sum = root.left.sum + root.right.sum;
		root.min = Math.min(root.left.min, root.right.min);
		root.max = Math.max(root.left.max, root.right.max);
		return root;
	}

	public int query(SegmentTreeNode node, int start, int end) {
		if (node == null) {
			return 0;
		}

		if (node.start == start && node.end == end) {
			return node.sum;
		}

		int mid = (node.start + node.end) >> 1;
		if (start <= mid && end <= mid) {
			return query(node.left, start, end);
		}
		else if (start > mid && end > mid) {
			return query(node.right, start, end);
		}
		else {
			return query(node.left, start, mid) + query(node.right, mid + 1, end);
		}
	}

	public int queryMax(SegmentTreeNode node, int start, int end) {
		if (node == null) {
			return 0;
		}

		if (node.start == start && node.end == end) {
			return node.max;
		}

		int mid = (node.start + node.end) >> 1;
		if (start <= mid && end <= mid) {
			return queryMax(node.left, start, end);
		}
		else if (start > mid && end > mid) {
			return queryMax(node.right, start, end);
		}
		else {
			return Math.max(queryMax(node.left, start, mid), queryMax(node.right, mid + 1, end));
		}
	}

	public void update(SegmentTreeNode node, int position, int val) {
		if (node == null) {
			return;
		}

		if (node.start == position && position == node.end) {
			node.sum = val;
			node.min = val;
			node.max = val;
			return;
		}

		int mid = (node.start + node.end) >> 1;
		if (position <= mid) {
			update(node.left, position, val);
		}
		else {
			update(node.right, position, val);
		}
		
		node.min = Math.min(node.left.min, node.right.min);
		node.max = Math.max(node.left.max, node.right.max);
		node.sum = node.left.sum + node.right.sum;
	}

	public SegmentTreeNode root;
	public int size;
	public SegmentTree(int[] nums) {
		this.root = build(nums, 0, nums.length - 1);
		this.size = nums.length;
	}

	public void update(int index, int val) {
		if (index < 0 || index >= size) {
			System.out.println("Index " + index + " is out of bound!");
			return;
		}
		update(root, index, val);
	}

	public int sumRange(int start, int end) {
		if (start < 0 || end >= size || start > end) {
			System.out.println("Invalid start: " + start + " and end index: " + end);
			return -1;
		}
		return query(root, start, end);
	}

	public int maxInRange(int start, int end) {
		if (start < 0 || end >= size || start > end) {
			System.out.println("Invalid start: " + start + " and end index: " + end);
			return -1;
		}
		return queryMax(root, start, end);
	}

	public static void main(String args[]) {
		int[] nums = {2, 5, 3, 100, 2, 3, 8, 3, 10};
		SegmentTree tree = new SegmentTree(nums);
		int sumRange = tree.sumRange(0, 6);
		System.out.println("Sum range between 0 and 6 is " + sumRange);
		tree.update(0, -3);
		tree.update(3, 20);
		sumRange = tree.sumRange(0, 6);
		System.out.println("Sum range between 0 and 6 now becomes " + sumRange);
		int max = tree.maxInRange(5,8);
		System.out.println("Max number between 5 and 8 is " + max);
		max = tree.maxInRange(2,8);
		System.out.println("Max number between 2 and 8 is " + max);

     }
}
