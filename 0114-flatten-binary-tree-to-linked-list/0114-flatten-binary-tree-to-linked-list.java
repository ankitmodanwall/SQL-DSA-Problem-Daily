// ✅ Approach 1: Extra Space (Preorder Traversal)
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> nodes = new ArrayList<>();
        preorder(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }
    }

    private void preorder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) return;
        nodes.add(node);
        preorder(node.left, nodes);
        preorder(node.right, nodes);
    }
}