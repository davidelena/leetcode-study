package com.david.leetcode;

import org.testng.annotations.Test;

public class SortedArrayToBST {

    @Test
    public void testSortedArrayToBST() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return composeBST(0, nums.length - 1, nums);
    }

    /**
     * generate
     *
     * @param start
     * @param end
     * @param nums
     */
    public TreeNode composeBST(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int middle = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = composeBST(start, middle - 1, nums);
        treeNode.right = composeBST(middle + 1, end, nums);
        return treeNode;
    }
}
