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
    static class Pair {
        TreeNode node;
        int row;

        Pair(TreeNode node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Map<Integer, Integer> mp = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        int maxRow = Integer.MIN_VALUE;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode temp = p.node;
            int row = p.row;

            mp.put(row, temp.val);
            maxRow = Math.max(row, maxRow);

            if (temp.left != null) {
                q.add(new Pair(temp.left, row + 1));
            }
            if (temp.right != null) {
                q.add(new Pair(temp.right, row + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= maxRow; i++) {
            ans.add(mp.get(i));
        }
        return ans;
    }
}