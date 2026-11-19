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
    int index;

    TreeNode helper(int[] preorder, int min, int max) {
        if (index == preorder.length) {
            return null;
        }

        if (!(preorder[index] > min) || !(preorder[index] < max)) {
            return null;
        }

        int parent = preorder[index++];
        TreeNode root = new TreeNode(parent);
        root.left = helper(preorder, min, parent);
        root.right = helper(preorder, parent, max);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}