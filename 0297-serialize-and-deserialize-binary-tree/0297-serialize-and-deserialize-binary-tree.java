/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                sb.append("#,");
            } else {
                sb.append(temp.val + ",");
            }
            if (temp != null) {
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String s) {
        if (s.length() == 0) {
            return null;
        }

        String[] arr = s.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode parent = q.poll();
            if (!arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.add(left);
            }
            i++;
            
            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));