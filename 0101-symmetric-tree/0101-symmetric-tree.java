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
    boolean helper(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null && r2 == null;
        }

        if (r1.val != r2.val) {
            return false;
        }

        boolean left = helper(r1.left, r2.right);
        boolean right = helper(r1.right, r2.left);
        return left && right;
    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
}