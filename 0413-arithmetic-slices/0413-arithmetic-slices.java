class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int m = nums.length, cnt = 0;
        if(m <=2) return 0;

        int d = nums[1] - nums[0];
        int currcnt = 1, j = 0;

        for(int i =2; i<m; i++){
            if(nums[i] - nums[i-1] == d){
                currcnt++;
                if(currcnt >=2) cnt += ++j;
            }
            else{
                d = nums[i] - nums[i-1];
                currcnt = 1;
                j = 0;
            }
        }
        return cnt;
    }
}