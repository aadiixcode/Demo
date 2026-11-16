/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void helper(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> mp) {
        if (root == null) {
            return;
        }
        mp.put(root, parent);
        helper(root.left, root, mp);
        helper(root.right, root, mp);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> mp = new HashMap<>();
        helper(root, root, mp);

        int steps = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> st = new HashSet<>();
        st.add(target);
        q.add(target);
        while (!q.isEmpty()) {
            if (steps == k) {
                break;
            }
            int size = q.size();
            while (size > 0) {
                TreeNode temp = q.poll();
                TreeNode parent = mp.get(temp);
                TreeNode leftChild = temp.left;
                TreeNode rightChild = temp.right;
                if (!st.contains(parent) && parent != temp) {
                    st.add(parent);
                    q.add(parent);
                }
                if (leftChild != null && !st.contains(leftChild)) {
                    st.add(leftChild);
                    q.add(leftChild);
                }
                if (rightChild != null && !st.contains(rightChild)) {
                    st.add(rightChild);
                    q.add(rightChild);
                }
                size -= 1;
            }
            steps += 1;
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}