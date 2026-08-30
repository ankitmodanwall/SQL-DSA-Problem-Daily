import java.util.*;

class Solution {

    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int answer = 0;

        // Try removing no element (-1)
        // and removing each element (0 to n-1)
        for (int remove = -1; remove < n; remove++) {

            int size = n;

            if (remove != -1) {
                size--;
            }

            // Create array after removal
            int[] arr = new int[size];

            int index = 0;

            for (int i = 0; i < n; i++) {
                if (i == remove) {
                    continue;
                }

                arr[index++] = nums[i];
            }

            // Array of length 1 has no split
            if (size < 2) {
                continue;
            }

            // Prefix GCD
            int[] prefix = new int[size];

            prefix[0] = arr[0];

            for (int i = 1; i < size; i++) {
                prefix[i] = gcd(prefix[i - 1], arr[i]);
            }

            // Suffix GCD
            int[] suffix = new int[size];

            suffix[size - 1] = arr[size - 1];

            for (int i = size - 2; i >= 0; i--) {
                suffix[i] = gcd(suffix[i + 1], arr[i]);
            }

            // Check valid splits
            int score = 0;

            for (int i = 0; i < size - 1; i++) {

                if (prefix[i] == suffix[i + 1]) {
                    score++;
                }
            }

            answer = Math.max(answer, score);
        }

        return answer;
    }

    // Euclidean Algorithm
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}