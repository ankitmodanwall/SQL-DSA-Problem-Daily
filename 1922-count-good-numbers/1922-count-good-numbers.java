class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
       long m = n/2;
       long left = n - n/2;
       long even = (long) (power( 5 , left) % MOD);
       long prime =(long) (power(4 , m) % MOD);
       return (int) ((even * prime) % MOD);
    }

    long power(long base , long pow){

        long ans = 1 ;

        while(pow > 0){
            if((pow & 1) == 1) ans = (ans * base)%MOD;
            base = (base * base)%MOD;
            pow = pow >> 1;
        }
        // System.out.println(ans);
        return ans;
    }

}