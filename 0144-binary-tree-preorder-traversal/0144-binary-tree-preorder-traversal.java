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
    List<Integer> res = new ArrayList<>();
        if (root == null)
        {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            res.add(curr.val);

            if (curr.right != null)
            st.push(curr.right);

            if(curr.left != null)
            st.push(curr.left);
        }
        return res;
    }
}