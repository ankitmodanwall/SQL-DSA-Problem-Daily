class Solution {
    public int countElements(int[] nums, int k) {
        if(k == 0) return nums.length;
        Arrays.sort(nums);
        int i = nums.length - k , n = nums[i];
        if(nums[0] == n) return 0;
        while(n == nums[i]) i--;
        return i+1;
    }
}