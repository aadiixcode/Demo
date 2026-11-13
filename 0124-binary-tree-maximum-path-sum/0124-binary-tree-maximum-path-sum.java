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
    int maxSum;

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(depth(root.left), 0);
        int right = Math.max(depth(root.right), 0);

        int sum = root.val + left + right;
        maxSum = Math.max(maxSum, sum);

        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = 0;
        depth(root);
        return maxSum;
    }
}