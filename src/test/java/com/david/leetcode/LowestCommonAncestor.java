package com.david.leetcode;

public class LowestCommonAncestor {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversalTree(root, p, q);
        return this.ans;
    }

    public boolean traversalTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        int left = traversalTree(currentNode.left, p, q) ? 1 : 0;
        int right = traversalTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            this.ans = currentNode;
        }

        return (left + right + mid) > 0;
    }
}
