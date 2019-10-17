package com.david.leetcode;

import org.testng.annotations.Test;

/**
 * Issue 104
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * @author Administrator
 *
 */
public class MaxDepthOfBinaryTree {

	@Test
	public void testMaxDepth() {
		Integer[] nums = new Integer[] { 3, 9, 20, null, null, 15, 7 };
		// 子节点最大为2(nums.length-1)+2=2nums.length+2
		TreeNode[] treeNodes = Tree.generateTree(nums);
		System.out.println(maxDepth(treeNodes[0]));
	}

	public int maxDepth(TreeNode node) {
		if (node != null) {
			int left = maxDepth(node.left) + 1;
			int right = maxDepth(node.right) + 1;
			return Math.max(left, right);
		}

		return 0;
	}

}
