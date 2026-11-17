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
    int k;

    TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        if (left != null)
            return left;

        k -= 1;
        if (k == 0) {
            return root;
        }

        return helper(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return helper(root).val;
    }
}