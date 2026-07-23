class Solution {
    private int getHeight(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void fill(String result[][], TreeNode node, int i, int left, int right) {
        if(node == null) return;
        result[i][left + (right - left) / 2] = "" + node.val;
        fill(result, node.left, i + 1, left, left + (right - left) / 2);
        fill(result, node.right, i + 1, left + (right - left) / 2, right);
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String result[][] = new String[height][(1 << height) - 1] ;
        for(String arr[] : result) Arrays.fill(arr, "");
        List<List<String>> ans = new ArrayList<>();
        fill(result, root, 0, 0, result[0].length);
        for(String arr[] : result) ans.add(Arrays.asList(arr));
        return ans;
    }
}

