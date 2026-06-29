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
    private int cnt = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
    // int left = new root.left;
    // int right = new root.right;
    inorder(root, k);
    return res;
    }   
        private void inorder(TreeNode node, int k ){
        if(node == null)
        return ;

        inorder(node.left, k);

        cnt++;
        if(cnt == k){
            res = node.val;
            return ;
        }
        inorder(node.right, k);

}
}