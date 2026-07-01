class Solution {
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        solve(root);
        return ans;
    }

    private int[] solve(TreeNode root) {
        if (root == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 1};

        int[] a = solve(root.left);
        int[] b = solve(root.right);

        if (a[3] == 1 && b[3] == 1 && a[2] < root.val && b[1] > root.val) {
            int sum = root.val + a[0] + b[0];
            ans = Math.max(ans, sum);
            return new int[]{sum, Math.min(a[1], root.val), Math.max(b[2], root.val), 1};
        }

        return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}