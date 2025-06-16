/**
 * Solution 1: slow, >5%
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
    public boolean isValidBST(TreeNode root) {
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        long preVal = Long.MIN_VALUE;
        root = root.left;

        while (stack.size()!=0 || root!=null) {
            while (root!=null) {
                stack.add(root);
                root= root.left;
            }
            root = stack.remove(stack.size()-1);
            int currVal = root.val;
            if (currVal<=preVal) return false;
            preVal = currVal;
            root=root.right;
        }
        return true;
    }
}
