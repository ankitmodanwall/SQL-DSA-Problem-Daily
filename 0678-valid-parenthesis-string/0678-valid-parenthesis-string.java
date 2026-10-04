class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                low++;
                high++;
            }

            else if (s.charAt(i) == ')') {
                low--;
                high--;
            }

            else { // '*'
                low--;
                high++;
            }

            // low cannot be negative
            if (low < 0) {
                low = 0;
            }

            // even maximum balance is negative
            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }
}