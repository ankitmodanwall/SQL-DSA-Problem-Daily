 class Pair {
    TreeNode node;
    boolean isLeft;

    Pair(TreeNode node, boolean isLeft) {
        this.node = node;
        this.isLeft = isLeft;
    }
}
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;

        Queue <Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, false));
        int sum = 0;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.node.left == null && p.node.right == null && p.isLeft){
                sum += p.node.val;
            }
            if(p.node.left != null) {
                queue.offer(new Pair(p.node.left, true));
            }
            if(p.node.right != null) {
                queue.offer(new Pair(p.node.right, false));
            }
        }
        return sum;
    }
}