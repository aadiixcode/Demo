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
    Map<Integer, Integer> mp;

    TreeNode helper(int preOrderInd, int startInd, int endInd,
            int[] preorder) {

        if (startInd > endInd)
            return null;

        int value = preorder[preOrderInd];
        TreeNode root = new TreeNode(value);

        int valueInd = mp.get(value);

        int leftSize = valueInd - startInd;

        root.left = helper(
                preOrderInd + 1,
                startInd,
                valueInd - 1,
                preorder);

        root.right = helper(
                preOrderInd + leftSize + 1,
                valueInd + 1,
                endInd,
                preorder);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }

        return helper(0, 0, inorder.length - 1, preorder);
    }
}
