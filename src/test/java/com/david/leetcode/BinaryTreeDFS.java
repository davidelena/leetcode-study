package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

public class BinaryTreeDFS {
    @Test
    public void testDFS() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode[] treeNodes = Tree.generateTree(nums);
        dfsBinaryTree(treeNodes[0]);
    }

    /**
     * dfs遍历二叉树
     */
    public void dfsBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = root;
        stack.push(currentNode);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            /*
             In order to traversal the node in depth as possible,
             We use stack to store the target node and pop it before we add its child nodes.
             For the reason if we add its children first, it may cause the confusion order.
             */
            TreeNode node = stack.pop();
            list.add(node.val);
            /*
             In order to guarantee traversal the left node in priority,
             we should use stack to add right node first.
             */
            if (currentNode.getRight() != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.getLeft() != null) {
                stack.push(currentNode.left);
            }
            if (!stack.isEmpty()) {
                currentNode = stack.peek();
            }

        }
        System.out.println(list);
    }
}
