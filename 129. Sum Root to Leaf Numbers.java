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
    private int totalSum=0;
    public int sumNumbers(TreeNode root) {
        backtrack(root, 0);
        return totalSum;
    }

    private void backtrack(TreeNode root, int currentSum) {
        if (root.left==null && root.right==null) { // leaf
            totalSum+=10* currentSum+root.val;
            return;
        }

        currentSum = currentSum * 10 + root.val;
        if (root.left!=null) {
            backtrack(root.left, currentSum);
        }
        if (root.right!=null) {
            backtrack(root.right, currentSum);
        }
    }
}
