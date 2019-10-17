package com.david.leetcode;

/**
 * 树节点
 * @author Administrator
 *
 */
public class TreeNode {
	Integer val;
	TreeNode left;
	TreeNode right;
	TreeNode(Integer x) {
		val = x;
	}

	public Integer getVal() {
		return val;
	}


	public void setVal(int val) {
		this.val = val;
	}


	public TreeNode getLeft() {
		return left;
	}


	public void setLeft(TreeNode left) {
		this.left = left;
	}


	public TreeNode getRight() {
		return right;
	}


	public void setRight(TreeNode right) {
		this.right = right;
	}


	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	
	
	
}
