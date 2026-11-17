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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            ans.add(curr.val);
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode rightMost = curr.left, temp = curr.left.right;
                while (temp != null) {
                    rightMost = temp;
                    temp = temp.right;
                }
                rightMost.right = curr.right;
                TreeNode prev = curr;
                curr = curr.left;
                prev.left = null;
            }
        }
        return ans;
    }
}