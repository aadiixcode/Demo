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
    Map<Integer, List<int[]>> mp;
    int minCol, maxCol;

    void helper(TreeNode root, int col, int row) {
        if (root == null) {
            return;
        }

        List<int[]> temp = (mp.containsKey(col)) ? mp.get(col) : new ArrayList<>();
        temp.add(new int[] { row, root.val });
        mp.put(col, temp);

        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);

        helper(root.left, col - 1, row + 1);
        helper(root.right, col + 1, row + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        mp = new HashMap<>();
        minCol = Integer.MAX_VALUE;
        maxCol = Integer.MIN_VALUE;
        helper(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            List<int[]> temp = mp.get(i);
            Collections.sort(temp, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            List<Integer> vertical = new ArrayList<>();
            for (int[] node : temp) {
                vertical.add(node[1]);
            }
            ans.add(vertical);
        }
        return ans;
    }
}