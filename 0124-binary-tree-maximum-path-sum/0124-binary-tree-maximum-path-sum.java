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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    maxpath(root);
    return max;
    }
    private int maxpath(TreeNode Node){
        if(Node == null)
        return 0;
        int left = Math.max(0, maxpath(Node.left));
        int right = Math.max(0, maxpath(Node.right));
        max = Math.max(max, Node.val + left+right);
        return Node.val+Math.max(left, right); 
    }
}