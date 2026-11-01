class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int x : nums){
            min = Math.min(min, x);

        }
        long moves = 0;
        for(int x : nums){
            moves += (long) x - min;

        }
        return (int )moves;
    }
}