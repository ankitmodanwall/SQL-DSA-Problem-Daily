class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevLast = -1;

            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;

                // Check if this block can be rotated into sorted order.
                int descents = 0;
                int descentIndex = -1;

                for (int i = start; i < end; i++) {
                    if (nums[i] > nums[i + 1]) {
                        descents++;
                        descentIndex = i;
                    }
                }

                if (nums[end] > nums[start]) {
                    descents++;
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                // Find the minimum and maximum of the rotated block.
                int min = nums[start];
                int max = nums[start];

                for (int i = start + 1; i <= end; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }

                if (prevLast != -1 && prevLast > min) {
                    valid = false;
                    break;
                }

                prevLast = max;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}