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
    List<int[]> nodes;
    public void solve(TreeNode root, int i, int j) {

        if(root == null)
        return;

        nodes.add(new int[] {j, i, root.val});
        solve(root.left, i+1, j-1);
        solve(root.right, i+1, j+1);
    }
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            nodes = new ArrayList<>();
            solve(root, 0, 0);
            Collections.sort(nodes, (a,b) -> {
                if(a[0] == b[0] && a[1] == b[1]) return a[2] -b[2];
                if(a[0] == b[0] ) return a[1] -b[1];
                return a[0] - b[0];
                
             });

             List<List<Integer>> res = new ArrayList<>();
             int i = 0;
             while(i<nodes.size()){
                ArrayList<Integer> curr = new ArrayList<>();
                int col = nodes.get(i)[0];
                while(i<nodes.size() && nodes.get(i)[0] == col){
                    curr.add(nodes.get(i)[2]);
                    i++;
                }
                res.add(curr);
             }
             return res;
        }
}