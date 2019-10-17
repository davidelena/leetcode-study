package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

public class LevelOrder {

    @Test
    public void testLevelOrder() {
        Integer[] nums = new Integer[]{3, 9, 20, 16, 18, 15, 7};
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            treeNodes[i] = new TreeNode(nums[i]);
        }
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[1].right = treeNodes[4];
        treeNodes[2].left = treeNodes[5];
        treeNodes[2].right = treeNodes[6];
        List<List<Integer>> list = levelOrder(treeNodes[0]);
        for (List<Integer> item : list) {
            System.out.println(item);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currentNode = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                //pop first element in this queue
                TreeNode node = queue.poll();
                // get second element in this queue
                currentNode = queue.peek();
                if (node != null) {
                    list.add(node.val);
                }
            }
            resList.add(list);
        }
        return resList;
    }

    public void bfsBinaryTree(List<Integer> list, TreeNode root) {

        System.out.println(list);
    }
}
