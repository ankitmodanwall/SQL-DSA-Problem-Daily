import java.util.*;

class Solution {

    int n;
    int[][] arr;
    int[] next;
    Result[][] dp;

    class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        // [start, end, weight, originalIndex]
        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Find next non-overlapping interval
        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(i);
        }

        // Memoization
        dp = new Result[n][5];

        Result ans = solve(0, 0);

        // Convert List<Integer> to int[]
        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    // First interval whose start > current end
    int findNext(int i) {

        int low = i + 1;
        int high = n;

        int end = arr[i][1];

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][0] > end) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Memoization
    Result solve(int i, int count) {

        // Maximum 4 intervals
        if (i == n || count == 4) {
            return new Result(0, new ArrayList<>());
        }

        // Already calculated
        if (dp[i][count] != null) {
            return dp[i][count];
        }

        // --------------------
        // OPTION 1: SKIP
        // --------------------
        Result skip = solve(i + 1, count);

        // --------------------
        // OPTION 2: TAKE
        // --------------------
        Result future = solve(next[i], count + 1);

        List<Integer> takeIndices =
                new ArrayList<>(future.indices);

        takeIndices.add(arr[i][3]);

        // Sort indices because answer must be
        // lexicographically compared
        Collections.sort(takeIndices);

        Result take = new Result(
                arr[i][2] + future.score,
                takeIndices
        );

        // --------------------
        // CHOOSE BEST
        // --------------------
        Result best;

        if (take.score > skip.score) {

            best = take;

        } else if (take.score < skip.score) {

            best = skip;

        } else {

            // Same score → lexicographically smaller
            if (isSmaller(take.indices, skip.indices)) {
                best = take;
            } else {
                best = skip;
            }
        }

        dp[i][count] = best;

        return best;
    }

    // Compare two lists lexicographically
    boolean isSmaller(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        // If one is prefix of another,
        // shorter one is lexicographically smaller
        return a.size() < b.size();
    }
}