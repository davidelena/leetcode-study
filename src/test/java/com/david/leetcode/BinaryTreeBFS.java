package com.david.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.testng.annotations.Test;

public class BinaryTreeBFS {

    @Test
    public void testBFS() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode[] treeNodes = Tree.generateTree(nums);
        bfsBinaryTree(treeNodes[0]);
    }

    /**
     * bfs遍历二叉树
     */
    public void bfsBinaryTree(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currentNode = root;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
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
        System.out.println(list);
    }
}
