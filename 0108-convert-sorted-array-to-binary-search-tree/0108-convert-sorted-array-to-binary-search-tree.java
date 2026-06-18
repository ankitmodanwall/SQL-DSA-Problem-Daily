class Solution {
    public TreeNode getRoot(int[] nums, int l, int r) {
        if (r < 0 || l >= nums.length || l > r)
            return null;
        
        
        int mid = Math.floorDiv(l + r, 2);
        TreeNode n = new TreeNode(nums[mid]);
        
        
        n.left = getRoot(nums, l, mid - 1);
        n.right = getRoot(nums, mid + 1, r);
        
        
        return n;
    }
    
    
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode n = getRoot(nums, 0, nums.length);
        return n;
    }
}