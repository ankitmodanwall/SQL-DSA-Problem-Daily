class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), total = 0;
        for(int i = 0; i <n; i++){
            BitSet seen = new BitSet(101);
            for(int j = i; j <n; j++){
                seen.set(nums.get(j));
                int d = seen.cardinality();
                total += d*d;
            }
        }
        return total;
    }
}