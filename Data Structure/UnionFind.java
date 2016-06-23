class UnionFind {
	private int[] id;
	private int count;

	public UnionFind(int num) {
		id = new int[num];
		count = num;
		for (int i = 0; i < num; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		// p and q are already in the same component
		if (pRoot == qRoot) {
			return;
		}
        
        // Put p into q's component
		id[pRoot] = qRoot;
		--count;
	}
}