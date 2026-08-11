class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i< n+1; i++){
            arr[i] = -1;
        }
        return climb(arr,n);
    }
        private int climb(int arr[], int n){
    if(n == 2 || n==1)
    // arr[n] = n
    return n;

if(arr[n] != -1) 
return arr[n];
        arr[n] = climb(arr, n-1) + climb(arr, n-2);
    // return climbStairs(n-1) + climbStairs(n-2); 
        
    return arr[n];
        }
}