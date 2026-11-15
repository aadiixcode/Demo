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
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int width = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode temp = p.node;
                int index = p.index;
                if (i == 0) {
                    minIndex = index;
                }
                if (i == size - 1) {
                    maxIndex = index;
                }

                if (temp.left != null) {
                    q.add(new Pair(temp.left, 2 * index + 1));
                }
                if (temp.right != null) {
                    q.add(new Pair(temp.right, 2 * index + 2));
                }
            }
            width = Math.max(width, maxIndex - minIndex + 1);
        }
        return width;
    }
}