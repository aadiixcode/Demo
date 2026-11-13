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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            while (size > 0) {
                TreeNode temp = q.poll();
                row.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                size -= 1;
            }
            if (level % 2 == 1) {
                Collections.reverse(row);
            }
            ans.add(row);
            level += 1;
        }
        return ans;
    }
}