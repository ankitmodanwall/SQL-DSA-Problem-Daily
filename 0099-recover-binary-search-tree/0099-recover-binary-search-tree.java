
class Solution {
    TreeNode first, second, prev;
    private void helper(TreeNode node) {
        if(node == null) return ;
        helper(node.left);
        if(prev != null && prev.val >node.val){
            if(first == null) first = prev;
                second = node;
        }
        prev = node;
        helper(node.right);
    }
    public void recoverTree(TreeNode root ){
        helper(root);

        first.val = first.val ^ second.val;
        second.val = first.val ^ second.val;
        first.val = first.val ^ second.val;
    }
}