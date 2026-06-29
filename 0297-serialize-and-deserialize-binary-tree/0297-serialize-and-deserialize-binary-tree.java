/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.*;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                sb.append("null,");
                continue;

            }
            sb.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

            while(!q.isEmpty()&& i<arr.length){
                TreeNode curr = q.poll();

                if(!arr[i].equals("null")){
                    curr.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(curr.left);
                }
                i++;
                  if(i <arr.length && !arr[i].equals("null")){
                    curr.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(curr.right);
                }
                i++;
            }
            return root;
        
    }}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));