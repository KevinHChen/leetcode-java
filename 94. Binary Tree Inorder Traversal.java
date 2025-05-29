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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> collector = new ArrayList<Integer>();
        if (root == null)
            return collector;

        List<TreeNode> stack = new ArrayList<TreeNode>();
        stack.add(root);
        TreeNode current = root.left;

        while (stack.size() != 0 || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode node = stack.remove(stack.size() - 1);
            collector.add(node.val);
            current = node.right;
        }
        return collector;
    }
}
