package com.david.leetcode;

public class Tree {
	
	/**
	 * 将数组转换为树
	 * @param nums
	 * @return
	 */
	public static TreeNode[] generateTree(Integer[] nums) {
		// 子节点最大为2(nums.length-1)+2=2nums.length+2
		TreeNode[] treeNodes = new TreeNode[2 * nums.length + 2];
		// 二叉树节点赋值
		for (int i = 0; i < nums.length; i++) {
			TreeNode node = null;
			if (nums[i] != null) {
				node = new TreeNode(nums[i]);
			}
			treeNodes[i] = node;
			System.out.println("node index=" + i + ", node=" + node);
		}

		// 构建组装二叉树，i为根节点，2i+1为左子节点，2i+2为又子节点
		for (int i = 0; i < nums.length; i++) {
			if (treeNodes[i] != null) {
				treeNodes[i].left = treeNodes[2 * i + 1];
				treeNodes[i].right = treeNodes[2 * i + 2];
			}
		}

		for (TreeNode treeNode : treeNodes) {
			System.out.println("treeNode=" + treeNode);
		}
		
		return treeNodes;
	}
}
