public class Trie {
	private int size;
	private TrieNode root;

	public Trie() {
		size = 26;
		root = new TrieNode();
	}

	public class TrieNode {
		private int count;
		private TrieNode[] children;
		private boolean isEnd;
		private char val;

		public TrieNode() {
			count = 1;
			children = new TrieNode[size];
			isEnd = false;
		}
	}

	public void insert(String str) {
		if (str == null || str.length() == 0) {
			return;
		}

		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int pos = letters[i] - 'a';
			if (node.children[pos] != null) {
				node.children[pos].count++;
			}
			else {
				node.children[pos] = new TrieNode();
				node.children[pos].val = letters[i];
			}
			node = node.children[pos];
		}
		node.isEnd = true;
	}

	public boolean query(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int pos = letters[i] - 'a';
			if (node.children[pos] != null) {
				node = node.children[pos];
			}
			else {
				return false;
			}
		}
		return node.isEnd;
	}

	public void delete(String str) {
		if (str == null || str.length() == 0) {
			return;
		}

		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int pos = letters[i] - 'a';
			if (node.children[pos].count == 1) {
				node.children[pos] = null;
				return;
			}
			else {
				node.children[pos].count--;
				node = node.children[pos];
			}
		}
		node.isEnd = false;
	}

	public TrieNode getRoot() {
		return this.root;
	}

	public void preTraverse(TrieNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			for (TrieNode child : node.children) {
				preTraverse(child);
			}
		}
		else {
			return;
		}
	} 

	public static void main(String[] args) {
		Trie tree = new Trie();  
        String[] strs={  
                "banana",
                "band",
                "bee",
                "absolute",
                "acm",
        };
        String[] prefix={
                "ba",
                "b",
                "band",
                "abc",
        };
        for(String str : strs){  
            tree.insert(str);
        }  
        tree.preTraverse(tree.getRoot());  
        System.out.println();  
        tree.delete("absolute");
        tree.preTraverse(tree.getRoot());
        System.out.println();
    }
}