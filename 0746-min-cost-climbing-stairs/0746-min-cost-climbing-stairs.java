class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] a = new int[cost.length+1];
        Arrays.fill(a, -1);
        return Math.min(sol(a, cost, 0), sol(a, cost, 1));
    }
    int sol (int a[], int cost[], int i){
        if(i>= cost.length){
            return 0;
        }
        if(a[i]!=-1) return a[i];
        a[i] = cost[i]+Math.min(sol(a, cost, i+1), sol(a, cost, i +2));
        return a[i];
    }
}