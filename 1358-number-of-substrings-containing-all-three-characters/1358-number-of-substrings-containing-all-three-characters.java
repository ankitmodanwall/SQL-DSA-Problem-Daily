class Solution {
    public int numberOfSubstrings(String s) {
       int a = -1, b = -1, c = -1, total = 0;
       int min=Integer.MAX_VALUE;
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                a = i;
            }
            else if (ch == 'b'){
                b = i;
            }
            else{
                c = i;
            }
            min = Math.min(a, Math.min(b,c));
if(a>-1 && b>-1 && c >-1){
                total += (1+min);
            }
            
}      
 return total;
        }
    }