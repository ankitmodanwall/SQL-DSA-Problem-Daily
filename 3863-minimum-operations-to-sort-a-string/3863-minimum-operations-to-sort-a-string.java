class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char min = s.charAt(0);
        char max = s.charAt(0);
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            char current = s.charAt(i);

            min = (char) Math.min(min, current);
            max = (char) Math.max(max, current);

            if (current < s.charAt(i - 1)) {
                sorted = false;
            }
        }

        // Already sorted
        if (sorted) {
            return 0;
        }

        // An unsorted two-character string cannot be changed
        if (n == 2) {
            return -1;
        }

        // Sort everything except the correct boundary
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Check whether min or max occurs internally
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        // Max is only at the start and min is only at the end
        return 3;
    }
}