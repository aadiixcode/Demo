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
    class Pair {
        TreeNode start, end;

        Pair(TreeNode start, TreeNode end) {
            this.start = start;
            this.end = end;
        }
    }

    Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(null, null);
        }

        if (root.left == null && root.right == null) {
            return new Pair(root, root);
        }

        Pair lst = helper(root.left);
        Pair rst = helper(root.right);

        TreeNode lsStart = lst.start, lsEnd = lst.end, rsStart = rst.start, rsEnd = rst.end;

        if (lsStart != null && rsStart != null) {
            root.right = lsStart;
            lsEnd.right = rsStart;
            root.left = null;
            return new Pair(root, rsEnd);
        } else if (lsStart == null) {
            root.right = rsStart;
            root.left = null;
            return new Pair(root, rsEnd);
        }

        root.right = lsStart;
        root.left = null;
        return new Pair(root, lsEnd);
    }

    public void flatten(TreeNode root) {
        helper(root);
    }
}