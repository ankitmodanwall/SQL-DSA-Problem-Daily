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
 import java.util.*;
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
int cnt = cnt_nodes(root);
return cnt;


}

private int cnt_nodes(TreeNode node){



        Deque<TreeNode> q_nodes = new ArrayDeque<>();
        Deque<Long> q_idx = new ArrayDeque<>();
        long max_size = 0;
        long first = -1, last = -1;
        q_nodes.offer(node);
        q_idx.offer(0L);
        while(!q_nodes.isEmpty()){
            int size = q_nodes.size();
            first = -1;
            last = -1;
                while(size -- !=0){
                    long idx = q_idx.poll();
                    TreeNode temp = q_nodes.poll();

                    if(first == -1) first = idx;
                    last = idx;

                    if(temp.left != null){
                        q_nodes.offer(temp.left);
                        // q_idx.offer(temp.left);
                        q_idx.offer(idx * 2);
                    }
                    if(temp.right != null){
                          q_nodes.offer(temp.right);
                           q_idx.offer(idx*2+1);
                    } 
        }
                max_size = Math.max(last - first +1, max_size);
        }
        return (int) max_size;
    }
}