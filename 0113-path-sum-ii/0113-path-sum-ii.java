class Solution {

    private void dfs(TreeNode root, int targetSum, int curSum,
                     List<Integer> path, List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        curSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && curSum == targetSum) {
            ans.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum, curSum, path, ans);
        dfs(root.right, targetSum, curSum, path, ans);

        path.remove(path.size() - 1); // backtracking
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, 0, path, ans);

        return ans;
    }
}