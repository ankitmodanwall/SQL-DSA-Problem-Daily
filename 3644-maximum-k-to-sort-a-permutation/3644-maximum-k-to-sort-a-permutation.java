class Solution {
    public int sortPermutation(int[] nums) {
        int n= nums.length;
        int k = -1;
        for(int i = 0; i<n; i++){
            if(nums[i] != i){
                k &= nums[i];
                if(k ==0) return 0;
            }
        }
        return Math.max(k, 0);
    }
}