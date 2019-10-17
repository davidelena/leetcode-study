package com.david.leetcode;

public class Trie {
	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!node.containsKey(c)) {
				node.put(c, new TrieNode());
			}
			node = node.get(c);
		}
		node.setEnd();
	}

	/**
	 * 搜索前缀
	 * 
	 * @param key
	 * @return
	 */
	public TrieNode searchPrefix(String key) {
		TrieNode node = root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			if (node.containsKey(c)) {
				node = node.get(c);
			} else {
				return null;
			}
		}
		return node;
	}

	public boolean search(String key) {
		TrieNode node = searchPrefix(key);
		return node != null && node.isEnd();
	}

	public boolean startWith(String key) {
		TrieNode node = searchPrefix(key);
		return node != null;
	}

	public String searchLongestCommonPrefix(String word) {
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.containsKey(c) && !node.isEnd() && node.getLinks() == 1) {
				sb.append(c);
				node = node.get(c);
			} else {
				return sb.toString();
			}
		}

		return sb.toString();
	}

}
