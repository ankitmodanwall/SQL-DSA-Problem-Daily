class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        for(int ch: s.toCharArray()){
            if(ch == '('){
                open++;
            }
            else {
                if(open > 0){
                    open--;
                }
                else {
                    close++;
                }
            }
        }
        return open + close;
    }
}