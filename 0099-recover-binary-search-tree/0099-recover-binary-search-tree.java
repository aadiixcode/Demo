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

    TreeNode n1, n2;
    TreeNode prev;

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);

        if (prev != null && prev.val > root.val) {
            if (n1 == null) {
                n1 = prev;
            }
            n2 = root;
        }
        prev = root;
        helper(root.right);
    }

    public void recoverTree(TreeNode root) {
        n1 = null;
        n2 = null;
        prev = null;

        helper(root);

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}