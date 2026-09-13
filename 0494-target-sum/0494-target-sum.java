class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        // Total sum of all numbers
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // We need:
        // required = (total + target) / 2
        //
        // If total + target is negative,
        // required sum is impossible.
        if (total + target < 0) {
            return 0;
        }

        // required must be an integer.
        // Therefore total + target must be even.
        if ((total + target) % 2 != 0) {
            return 0;
        }

        int required = (total + target) / 2;

        // Count subsets whose sum is 'required'
        return solve(nums, 0, required);
    }


    private int solve(int[] nums, int i, int sum) {

        // All elements processed
        if (i == nums.length) {

            // Exact sum achieved
            if (sum == 0) {
                return 1;
            }

            // Sum not achieved
            return 0;
        }


        // OPTION 1: Skip current number
        int skip = solve(
            nums,
            i + 1,
            sum
        );


        // OPTION 2: Take current number
        int take = 0;

        if (nums[i] <= sum) {

            take = solve(
                nums,
                i + 1,
                sum - nums[i]
            );
        }


        // We are COUNTING ways.
        // Therefore add both branches.
        return take + skip;
    }
}