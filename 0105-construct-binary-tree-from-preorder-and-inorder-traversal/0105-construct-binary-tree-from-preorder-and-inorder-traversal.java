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

    TreeNode helper(int[] preOrderInd, int startInd, int endInd,
            int[] preorder) {

        if (startInd > endInd) {
            return null;
        }

        int value = preorder[preOrderInd[0]];
        TreeNode root = new TreeNode(value);
        int valueInd = mp.get(value);

        preOrderInd[0] += 1;
        root.left = helper(
                preOrderInd,
                startInd,
                valueInd - 1,
                preorder);
        root.right = helper(
                preOrderInd,
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

        return helper(new int[] { 0 }, 0, inorder.length - 1, preorder);
    }
}
