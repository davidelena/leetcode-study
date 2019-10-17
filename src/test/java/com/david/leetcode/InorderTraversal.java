package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    @Test
    public void testInorderTraversal() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Integer[] nums = new Integer[]{1, null, 2, 3};
        TreeNode[] treeNodes = Tree.generateTree(nums);
        List<Integer> list = inorderTraversal(treeNodes[0]);
        System.out.println(list);
    }

    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }

    public void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversalHelper(root.left, list);
        }

        if (root != null) {
            list.add(root.val);
        }

        if (root.right != null) {
            inorderTraversalHelper(root.right, list);
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        // Use stack to implement the inorder traversal, left->node->right
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left; // move to the next node
            }
            // if the left child node is null, pop the current node;
            currentNode = stack.pop();
            list.add(currentNode.val);

            // Add the right node if current node has its rights node. End this traversal.
            currentNode = currentNode.right;

        }
        return list;
    }
}
