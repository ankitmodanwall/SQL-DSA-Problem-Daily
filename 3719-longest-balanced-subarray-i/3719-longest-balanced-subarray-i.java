class Solution {
    public int longestBalanced(int[] nums) {
        int res = 0;
        HashSet<Integer> odd =  new HashSet<>(), 
        even = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            odd.clear();
            even.clear();

            for(int j = i; j<nums.length; j++){
                int num = nums[j];
                if((num & 1) ==1) odd.add(num);
                else even.add(num);
                if(odd.size() == even.size()){
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }
}