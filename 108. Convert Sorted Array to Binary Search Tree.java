/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left>right) return null;
        if (left==right) return new TreeNode(nums[left]);
        
        int mid = (left+right)/2;
        return new TreeNode(nums[mid], buildTree(nums, left, mid-1), buildTree(nums, mid+1, right));
    }
}
