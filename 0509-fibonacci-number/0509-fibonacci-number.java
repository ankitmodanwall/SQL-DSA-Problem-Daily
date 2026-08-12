class Solution {
    public int fib(int n) {

        if (n < 2)
            return n;
       /* if (n == 0 || n == 1)
            return true;
*/
        int a = 0, b = 1;

    for (int i = 2 ; i <= n ; i++){
         int   next = a + b;
            a = b;
            b = next;

        }
        return b;

    }
}