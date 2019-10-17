package com.david.leetcode;


/**
 * 字典树trie(发音try)树
 *
 * @author Administrator
 *
 */
public class TrieNode {
	private int R = 26;
	private TrieNode[] links;
	private boolean isEnd;
	private int size;

	public TrieNode() {
		this.links = new TrieNode[R];
	}

	public int getR() {
		return R;
	}

	public int getLinks() {
		return size;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd() {
		this.isEnd = true;
	}

	public void put(char c, TrieNode node) {
		links[c - 'a'] = node;
		size++;
	}

	public boolean containsKey(char c) {
		return links[c - 'a'] != null;
	}

	public TrieNode get(char c) {
		return links[c - 'a'];
	}

}
