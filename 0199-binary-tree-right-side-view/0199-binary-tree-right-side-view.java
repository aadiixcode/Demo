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
    int maxLevel;

    void helper(TreeNode root, int level, Map<Integer, Integer> mp) {
        if (root == null) {
            return;
        }

        mp.put(level, root.val);
        maxLevel = Math.max(level, maxLevel);

        helper(root.left, level + 1, mp);
        helper(root.right, level + 1, mp);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> mp = new HashMap<>();

        maxLevel = Integer.MIN_VALUE;
        helper(root, 0, mp);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= maxLevel; i++) {
            ans.add(mp.get(i));
        }
        return ans;
    }
}