package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 *
 */
public class BuildTree {

    @Test
    public void testBuildTree() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode node = buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int val = preorder[0];
        TreeNode treeNode = new TreeNode(val);
        int position = searchPosition(0, inorder, treeNode.val);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, position + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, position);
        int[] rightPreorder = Arrays.copyOfRange(preorder, position + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, position + 1, inorder.length);
        treeNode.left = buildTree(leftPreorder, leftInorder);
        treeNode.right = buildTree(rightPreorder, rightInorder);
        return treeNode;
    }

    public int searchPosition(int start, int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

}
