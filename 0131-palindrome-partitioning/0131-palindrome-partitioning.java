class Solution {
    int n;
    List<List<String>> res=new ArrayList<>();
    List<String> path=new ArrayList<>();
    public List<List<String>> partition(String s) {
        n=s.length();
        helper(s,0);
        return res;
    }
    public void helper(String s,int start){
        if(start==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end=start;end<n;end++){
            if(isPalindrome(s,start,end)){
                path.add(s.substring(start,end+1));
                helper(s,end+1);
                path.remove(path.size()-1);
            }
        }}
        public boolean isPalindrome(String s,int left,int right){
            while(left<=right){
                if(s.charAt(left)!=s.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        
    }
}