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
    TreeNode helper(int[] preorder, int start, int end) {
        if (end < start) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);

        // if (start == end) {
        //     return root;
        // }

        int index = start + 1;
        while (index <= end && preorder[index] < preorder[start]) {
            index += 1;
        }

        root.left = helper(preorder, start + 1, index - 1);
        root.right = helper(preorder, index, end);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
}